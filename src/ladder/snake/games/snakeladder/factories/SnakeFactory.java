package ladder.snake.games.snakeladder.factories;

import ladder.snake.Utils;
import ladder.snake.games.snakeladder.SnakeLadderCellLocation;
import ladder.snake.games.snakeladder.elements.Snake;
import ladder.snake.games.snakeladder.elements.SnakeLadderGameElement;

import java.awt.*;

public class SnakeFactory {
    private static SnakeFactory INSTANCE;

    private SnakeFactory() {
    }

    public static SnakeFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (SnakeFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SnakeFactory();
                }
            }
        }
        return INSTANCE;
    }

    public SnakeLadderGameElement getRandomSnake(int boardWidth, int boardHeight) {
        Point start = Utils.generatePoint(boardWidth, boardHeight);
        Point end = Utils.generatePoint(start.getX(), start.getY(), boardWidth, boardHeight);
        return new Snake(start, end);
    }
}
