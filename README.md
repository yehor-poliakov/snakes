## Snakes and Ladders backend stub
### Project description:
* Implements three features for Snakes and Ladders game:
    * creating a new game
    * moving player's token across an empty board
    * retrieving an existing game

### Specifications:
* SpringBoot MVC web-application on Kotlin
* Java 11, Kotlin 1.4
* Gradle build
* H2 in-memory database as a primary database
* Swagger to allow endpoint testing

### Run locally:
It should be enough to just build the project and run SnakesApplication.kt
In case of trouble, check whether you compile and run the project using Java 11

### Background story:
This project implements a "Moving your token" feature of the game Snakes and Ladders, in particular, three user stories and accompanying test descriptions. Tests for GameManager were designed right after basic model.   

Game model was designed to cover this feature only and thus does not make provisions for multiplayer (and thus there is no player model at all), authorization, etc.

However, to make future improvements easier, the project was designed in accordance with the MVC-pattern, connected to database and swagger.

In-memory H2 was chosen to avoid difficulties with configuration and is available at:

http://localhost:8080/h2-console/

Swagger is available at:

http://localhost:8080/swagger-ui.html