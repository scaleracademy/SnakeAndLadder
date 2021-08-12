package ladder.snake.games;

import ladder.snake.game.Game;
import ladder.snake.game.players.Player;
import ladder.snake.games.snakeladder.SnakeLadderGame;

import java.util.List;

public class GameFactory {
    private static GameFactory INSTANCE;

    private GameFactory() {
    }

    public static GameFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (GameFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GameFactory();
                }
            }
        }
        return INSTANCE;
    }

    public Game createClassicSnakeLadder(List<Player> players) {
        return new SnakeLadderGame.Builder()
                .snakes(5)
                .ladders(7)
                .boardWidth(10)
                .boardHeight(10)
                .players(players)
                .build();
    }
}
