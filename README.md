Design Patterns
===============

1. Builder
2. Factory
3. Singleton
4. Observer
5. Template

-- --

Class Diagram
-------------

![](class-diagram.png)

Structure
---------

```
`-- src
    `-- ladder
        `-- snake
            |-- Audience.java
            |-- Main.java
            |-- User.java
            |-- Utils.java
            |-- game                         - generic design for a game
            |   |-- ComputerStrategy.java
            |   |-- Game.java
            |   |-- GameController.java
            |   |-- GameState.java
            |   |-- GameStats.java
            |   |-- Move.java
            |   |-- events       
            |   |   |-- GameEvent.java
            |   |   |-- GameEventData.java
            |   |   |-- GameEventHandler.java
            |   |   `-- MoveMade.java
            |   `-- players
            |       |-- ComputerPlayer.java
            |       |-- HumanPlayer.java
            |       `-- Player.java
            `-- games                             - implementations of various games
                |-- GameFactory.java
                |-- RoundRobinTurnTracker.java
                |-- TurnTracker.java
                |-- botstrategies
                |   `-- RandomDiceRollSnakeLadderStrategy.java
                |-- exceptions
                |   |-- GameException.java
                |   |-- InvalidGamePlayerException.java
                |   |-- InvalidGameStateForActionException.java
                |   |-- InvalidMoveException.java
                |   `-- validation
                |       |-- InvalidBoardSizeException.java
                |       `-- ValidationException.java
                `-- snakeladder
                    |-- SnakeLadderCellLocation.java
                    |-- SnakeLadderGame.java
                    |-- SnakeLadderGameStats.java
                    |-- SnakeLadderMove.java
                    |-- elements
                    |   |-- Ladder.java
                    |   |-- Snake.java
                    |   `-- SnakeLadderGameElement.java
                    `-- factories
                        |-- LadderFactory.java
                        `-- SnakeFactory.java

```

