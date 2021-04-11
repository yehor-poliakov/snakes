package com.snakes.dto

import com.snakes.model.GameStage

data class GameDto (
    val boardSize: Int = 100,
    var playerPosition: Int = 1,
    var stage: GameStage = GameStage.Continue,
    var die: Int = 0
)