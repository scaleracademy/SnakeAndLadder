package ladder.snake.games.botstrategies;

import ladder.snake.game.ComputerStrategy;

public class RandomDiceRollSnakeLadderStrategy implements ComputerStrategy {
    @Override
    public int generate() {
        return (int) (Math.random() * 6);
    }
}
