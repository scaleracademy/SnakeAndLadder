package ladder.snake.games.snakeladder.elements;


import java.awt.*;

public class Snake implements SnakeLadderGameElement {
    private final Point start, end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Snake(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}
