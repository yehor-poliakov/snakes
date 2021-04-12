package com.snakes.converter

import com.snakes.dto.GameDto
import com.snakes.entity.GameEntity
import com.snakes.model.GameModel
import java.util.*

fun Optional<GameEntity>.toModel(): Optional<GameModel> = map {
    GameModel(it.id, it.boardSize, it.playerPosition, it.stage)
}

fun Optional<GameModel>.toDto(): Optional<GameDto> = map {
    GameDto(it.id, it.boardSize, it.playerPosition, it.stage, it.die)
}

@JvmName("toModelGameDto")
fun Optional<GameDto>.toModel(): Optional<GameModel> = map {
    GameModel(it.id, it.boardSize, it.playerPosition, it.stage)
}

fun Optional<GameModel>.toEntity(): Optional<GameEntity> = map {
    GameEntity(it.id, it.boardSize, it.playerPosition, it.stage)
}
