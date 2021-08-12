package ladder.snake.game.events;

import ladder.snake.game.Move;

public class MoveMade extends GameEventData {
    private Move move;

    public MoveMade(Move move) {
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "Move was made " + move.toString();
    }
}
