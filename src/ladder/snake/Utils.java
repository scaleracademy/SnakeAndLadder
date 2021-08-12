package ladder.snake;

import java.awt.*;

public class Utils {

    public static Point generatePoint(double maxX, double maxY) {
        return generatePoint(0, 0, maxX, maxY);
    }

    public static Point generatePoint(double startX, double startY, double maxX, double maxY) {
        return new Point(
                (int) (startX + Math.random() * (maxX - startX)),
                (int) (startY + Math.random() * (maxY - startY))
        );
    }
}
