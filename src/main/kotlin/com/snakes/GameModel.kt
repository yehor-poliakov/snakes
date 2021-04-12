package com.snakes

data class GameModel(
    val id: Long,
    val boardSize: Int = 100,
    var playerPosition: Int = 1,
    var stage: GameStage = GameStage.Continue,
    var die: Int = 0
)
