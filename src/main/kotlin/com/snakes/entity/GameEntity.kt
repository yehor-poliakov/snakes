package com.snakes.entity

import com.snakes.model.GameStage
import javax.persistence.*

@Entity
class GameEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "board", nullable = false)
    val boardSize: Int = 100,
    @Column(name = "playerPosition", nullable = false)
    var playerPosition: Int = 1,
    @Column(name = "stage", nullable = false) @Enumerated(EnumType.STRING)
    var stage: GameStage = GameStage.Continue
)
