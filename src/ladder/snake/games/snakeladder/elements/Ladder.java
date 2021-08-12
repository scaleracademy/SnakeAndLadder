package ladder.snake.games.snakeladder.elements;


import java.awt.*;

public class Ladder implements SnakeLadderGameElement {
    private final Point start, end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Ladder(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
}
