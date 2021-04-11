package com.snakes.model

import com.snakes.service.GameManager
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameModelTest {
    private val gameManager = GameManager()

    @Test
    fun `should place token on position one when placed first time`() {
        //Given the game is started, When the token is placed on the board
        val game = gameManager.newGame()

        //Then the token is on square 1
        assertEquals(1, game.playerPosition)
    }

    @Test
    fun `should place token on position four after first move of three`() {
        //Given the token is on square 1
        val game = gameManager.newGame()

        //When the token is moved 3 spaces
        val actualGame = gameManager.movePlayer(game, 3)

        //Then the token is on square 4
        assertEquals(4, actualGame.playerPosition)
    }

    @Test
    fun `should place token on position eight after moves of three and four`() {
        //Given the token is on square 1
        val game = gameManager.newGame()

        //When the token is moved 3 spaces
        gameManager.movePlayer(game, 3)
        //And then it is moved 4 spaces
        val actualGame = gameManager.movePlayer(game, 3)

        //Then the token is on square 8
        assertEquals(8, actualGame.playerPosition)
    }

    @Test
    fun `should return between one and six on first roll`() {
        /* Given the game is started
            When the player rolls a die
            Then the result should be between 1-6 inclusive */
        assertTrue(gameManager.rollDie() in 1..6)
    }

    @Test
    fun `should move token four spaces when roll result is four`() {
        val gameModel = gameManager.newGame()
        //Given the player rolls a 4
        val die = 4

        //When they move their token
        val resultGame = gameManager.movePlayer(gameModel, die)

        //Then the token should move 4 spaces
        assertEquals(5, resultGame.playerPosition)
    }

    @Test
    fun `should acknowledge player as winner after roll result of three at position ninety seven`() {
        //Given the token is on square 97
        val gameModel = GameModel(playerPosition = 97, id = 0)

        //When the token is moved 3 spaces
        val resultGame = gameManager.movePlayer(gameModel, 3)

        //Then the token is on square 100
        assertEquals(100, resultGame.playerPosition)
        //And the player has won the game
        assertEquals(GameStage.Victory, resultGame.stage)
    }

    @Test
    fun `should not move player nor acknowledge victory after roll result of four at position ninety seven`() {
        //Given the token is on square 97
        val gameModel = GameModel(playerPosition = 97, id = 0)

        //When the token is moved 4 spaces
        val resultGame = gameManager.movePlayer(gameModel, 4)

        //Then the token is on square 97
        assertEquals(97, resultGame.playerPosition)
        //And the player has not won the game
        assertEquals(GameStage.Continue, resultGame.stage)
    }

}
