package com.snakes.service

import com.snakes.model.GameModel
import com.snakes.model.GameStage
import kotlin.random.Random

class GameManager {
    fun rollDie() = Random.Default.nextInt(1, 7)

    fun movePlayer(game: GameModel, die: Int): GameModel {
        val newPosition = game.playerPosition + die
        return when {
            newPosition > game.boardSize -> {
                game.copy(die = die)
            }
            newPosition == game.boardSize -> {
                game.copy(playerPosition = newPosition, stage = GameStage.Victory, die = die)
            }
            else -> game.copy(playerPosition = newPosition, die = die)
        }
    }

    fun newGame() : GameModel = GameModel()
}
