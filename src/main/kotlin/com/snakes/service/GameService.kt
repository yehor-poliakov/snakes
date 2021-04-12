package com.snakes.service

import com.snakes.converter.toEntity
import com.snakes.converter.toModel
import com.snakes.GameModel
import com.snakes.repository.GameRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService(
    val repository: GameRepository,
    val manager: GameManager
) {
    fun getState(id: Long): Optional<GameModel> {
        val entity = repository.findById(id)
        return entity.toModel()
    }

    fun makeMove(id: Long): Optional<GameModel> {
        val model = repository.findById(id).toModel()
        if (model.isEmpty) {
            return model
        }
        val die = manager.rollDie()
        val newModel = manager.movePlayer(model.get(), die)
        val entity = Optional.of(newModel).toEntity().get()
        repository.save(entity)
        return Optional.of(newModel)
    }

    fun newGame(): Optional<GameModel> {
        val model = manager.newGame()
        val entity = Optional.of(model).toEntity().get()
        val resultEntity = repository.save(entity)
        return Optional.of(resultEntity).toModel()
    }
}
