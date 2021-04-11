package com.snakes.controller

import com.snakes.dto.GameDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {

    @GetMapping("/game/{id}")
    fun getState(@PathVariable id: Long): GameDto {
        TODO()
    }

    @PostMapping("/game")
    fun newGame(): GameDto {
        TODO()
    }

    @PostMapping("/game/{id}")
    fun makeMove(@PathVariable id: Long): GameDto {
        TODO()
    }
}
