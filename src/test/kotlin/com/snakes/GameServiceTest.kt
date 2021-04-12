package com.snakes

import com.snakes.entity.GameEntity
import com.snakes.repository.GameRepository
import com.snakes.service.GameManager
import com.snakes.service.GameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class GameServiceTest() {
    private val gameManager: GameManager = mockk()
    private val gameRepository: GameRepository = mockk()
    private val gameService = GameService(gameRepository, gameManager)

    @Test
    fun `should create new game`() {
        every { gameManager.newGame() } returns GameModel(id = 0)
        every { gameRepository.save(any()) } returns GameEntity(id = 123)

        val newGame = gameService.newGame()

        verify(exactly = 1) {
            gameManager.newGame()
            gameRepository.save(any())
        }
        assertEquals(Optional.of(GameModel(123)), newGame)
    }

    @Test
    fun `should get state of game`() {
        every { gameRepository.findById(123) } returns Optional.of(GameEntity(id = 123))

        val game = gameService.getState(123)

        verify(exactly = 1) {
            gameRepository.findById(123)
        }
        assertEquals(Optional.of(GameModel(123)), game)
    }

    @Test
    fun `should return empty game when there is no game`() {
        every { gameRepository.findById(123) } returns Optional.empty()

        val game = gameService.getState(123)

        verify(exactly = 1) {
            gameRepository.findById(123)
        }
        assertEquals(Optional.empty<GameModel>(), game)
    }

    @Test
    fun `should move player position`() {
        every { gameRepository.findById(123) } returns Optional.of(GameEntity(123))
        every { gameRepository.save(any()) } returns GameEntity(123)
        every { gameManager.rollDie() } returns 6
        every { gameManager.movePlayer(any(), 6) } returns GameModel(123, die = 6, playerPosition = 15)

        val game = gameService.makeMove(123)

        verify(exactly = 1) {
            gameRepository.findById(123)
            gameRepository.save(any())
            gameManager.rollDie()
            gameManager.movePlayer(any(), 6)
        }
        assertEquals(Optional.of(GameModel(123, die = 6, playerPosition = 15)), game)
    }

    @Test
    fun `should return empty model for non-existent game`() {
        every { gameRepository.findById(123) } returns Optional.empty()

        val game = gameService.makeMove(123)

        verify(exactly = 1) {
            gameRepository.findById(123)
        }
        assertEquals(Optional.empty<GameModel>(), game)
    }
}
