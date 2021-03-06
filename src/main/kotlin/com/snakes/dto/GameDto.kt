package com.snakes.dto

import com.snakes.GameStage

data class GameDto(
    val id: Long,
    val boardSize: Int = 100,
    var playerPosition: Int = 1,
    var stage: GameStage = GameStage.Continue,
    var die: Int = 0
)
