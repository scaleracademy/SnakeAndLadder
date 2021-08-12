package ladder.snake;

import ladder.snake.game.Game;
import ladder.snake.game.GameController;
import ladder.snake.game.players.ComputerPlayer;
import ladder.snake.game.players.HumanPlayer;
import ladder.snake.game.players.Player;
import ladder.snake.games.GameFactory;
import ladder.snake.games.botstrategies.RandomDiceRollSnakeLadderStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User salil = new User("Salil");
        User rahul = new User("Rahul");
        Audience swarup = new Audience("Swarup");
        Audience virendra = new Audience("Virendra");

        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer(salil, "blue"));
        players.add(new HumanPlayer(rahul, "red"));
        players.add(new ComputerPlayer("Bot1", "green", new RandomDiceRollSnakeLadderStrategy()));
        Game game = GameFactory.getInstance().createClassicSnakeLadder(players);

        GameController controller = new GameController(game);
        controller.addAudience(swarup);
        controller.addAudience(virendra);

        controller.startGame();
    }
}
