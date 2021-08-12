package ladder.snake.games.snakeladder;

import ladder.snake.game.Move;

public class SnakeLadderMove extends Move {
    private final int roll;

    public SnakeLadderMove(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "SnakeLadderMove(" + roll + ")";
    }
}
