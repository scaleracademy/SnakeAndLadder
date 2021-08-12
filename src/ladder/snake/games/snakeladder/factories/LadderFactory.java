package ladder.snake.games.snakeladder.factories;

import ladder.snake.Utils;
import ladder.snake.games.snakeladder.elements.Ladder;
import ladder.snake.games.snakeladder.elements.SnakeLadderGameElement;

import java.awt.*;

public class LadderFactory {
    private static LadderFactory INSTANCE;

    private LadderFactory() {
    }

    public static LadderFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (LadderFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LadderFactory();
                }
            }
        }
        return INSTANCE;
    }

    public SnakeLadderGameElement getRandomLadder(int boardWidth, int boardHeight) {
        Point start = Utils.generatePoint(boardWidth, boardHeight);
        Point end = Utils.generatePoint(start.getX(), start.getY(), boardWidth, boardHeight);
        return new Ladder(start, end);
    }
}
