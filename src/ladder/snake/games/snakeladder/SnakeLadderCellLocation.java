package ladder.snake.games.snakeladder;

@Deprecated
public class SnakeLadderCellLocation {
    private int row, col;

    public SnakeLadderCellLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}