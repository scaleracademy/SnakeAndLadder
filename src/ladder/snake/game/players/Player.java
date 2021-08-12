package ladder.snake.game.players;

import ladder.snake.game.Move;

public interface Player {
    Move generateMove();

    void notifyMoveMade(Move move);
}
