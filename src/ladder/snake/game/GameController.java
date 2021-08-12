package ladder.snake.game;

import ladder.snake.Audience;
import ladder.snake.game.events.GameEvent;
import ladder.snake.game.events.MoveMade;
import ladder.snake.game.players.Player;

public class GameController {
    private final Game game;
    private final GameEvent event;

    public GameController(Game game) {
        this.game = game;
        this.event = new GameEvent();
    }

    public void startGame() {
        game.initialize();
        while (!game.isOver()) {
            Player player = game.getPlayerWithTurn();
            Move move;
            do {
                move = player.generateMove();
            } while (!game.isMoveValid(move));
            game.makeMove(move);
            event.dispatchEvent(new MoveMade(move));
        }
        if (game.isADraw()) {
            System.out.println("game was a draw!");
        } else {
            GameStats winnerStats = game.getWinningPlayerStats();
            System.out.println("Game was won: " + winnerStats.toString());
        }
    }

    public void addAudience(Audience audience) {
        event.addListener(audience.getGameEventHandler());
    }
}

/*

Pro
- you get at least the v1 done



 */