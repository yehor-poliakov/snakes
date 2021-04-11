package com.snakes.controller

import com.snakes.converter.toDto
import com.snakes.dto.GameDto
import com.snakes.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class GameController
    (@Autowired val gameService: GameService) {

    @GetMapping("/game/{id}")
    fun getState(@PathVariable id: Long): GameDto =
        gameService
            .getState(id)
            .toDto()
            .orElseThrow { NotFoundException() }

    @PostMapping("/game")
    fun newGame(): GameDto =
        gameService
            .newGame()
            .toDto()
            .orElseThrow { NotFoundException() }

    @PostMapping("/game/{id}")
    fun makeMove(@PathVariable id: Long): GameDto =
        gameService
            .makeMove(id)
            .toDto()
            .orElseThrow { NotFoundException() }
}

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Game not found")
class NotFoundException : RuntimeException()
