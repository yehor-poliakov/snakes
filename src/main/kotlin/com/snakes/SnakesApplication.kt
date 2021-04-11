package com.snakes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SnakesApplication

fun main(args: Array<String>) {
	runApplication<SnakesApplication>(*args)
}
