package com.snakes.repository

import com.snakes.entity.GameEntity
import org.springframework.data.repository.CrudRepository

interface GameRepository : CrudRepository<GameEntity, Long> {

}
