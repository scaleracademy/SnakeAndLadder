package ladder.snake.game.players;

import ladder.snake.game.ComputerStrategy;
import ladder.snake.game.Move;
import ladder.snake.games.snakeladder.SnakeLadderMove;

public class ComputerPlayer implements Player {
    private final String name, symbol;
    private final ComputerStrategy strategy;

    public ComputerPlayer(String name, String symbol, ComputerStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }

    @Override
    public Move generateMove() {
        int roll = strategy.generate();
        System.out.println(this.toString() + " and I rolled a " + roll);
        return new SnakeLadderMove(roll);
    }

    @Override
    public void notifyMoveMade(Move move) {

    }


    @Override
    public String toString() {
        return "hi, I'm Bot " + name;
    }
}
