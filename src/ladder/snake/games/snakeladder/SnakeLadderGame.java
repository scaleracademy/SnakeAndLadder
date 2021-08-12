package ladder.snake.games.snakeladder;

import ladder.snake.game.Game;
import ladder.snake.game.GameState;
import ladder.snake.game.GameStats;
import ladder.snake.game.Move;
import ladder.snake.game.players.Player;
import ladder.snake.games.RoundRobinTurnTracker;
import ladder.snake.games.TurnTracker;
import ladder.snake.games.exceptions.InvalidGamePlayerException;
import ladder.snake.games.exceptions.InvalidGameStateForActionException;
import ladder.snake.games.exceptions.InvalidMoveException;
import ladder.snake.games.exceptions.validation.InvalidBoardSizeException;
import ladder.snake.games.snakeladder.elements.SnakeLadderGameElement;
import ladder.snake.games.snakeladder.factories.LadderFactory;
import ladder.snake.games.snakeladder.factories.SnakeFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame implements Game {
    private final int snakesCount, laddersCount, boardWidth, boardHeight;
    private final List<Player> players;
    private GameState gameState;
    private TurnTracker turnTracker;
    private Integer playerWithTurn;

    Map<Player, Point> playerLocations;
    List<SnakeLadderGameElement> elements;

    private SnakeLadderGame(Builder builder) {
        this.gameState = GameState.WAITING_FOR_PLAYERS;
        this.snakesCount = builder.snakes;
        this.laddersCount = builder.ladders;
        this.boardWidth = builder.boardWidth;
        this.boardHeight = builder.boardHeight;
        this.players = builder.players;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing Classic Snake Ladder");
        this.elements = new ArrayList<>();
        this.playerLocations = new HashMap<>();
        for (Player player : players) {
            playerLocations.put(player, new Point(0, 0));
        }
        for (int s = 0; s < snakesCount; s++) {
            elements.add(SnakeFactory.getInstance().getRandomSnake(boardWidth, boardHeight));
        }
        for (int s = 0; s < laddersCount; s++) {
            elements.add(LadderFactory.getInstance().getRandomLadder(boardWidth, boardHeight));
        }
        playerWithTurn = 0;
        turnTracker = new RoundRobinTurnTracker(players.size());
        gameState = GameState.STARTED;
        System.out.println("Initialized!");
    }

    @Override
    public void addPlayer(Player player) {
        if (gameState.equals(GameState.STARTED))
            throw new InvalidGameStateForActionException("can't add player mid game");
        else if (gameState.equals(GameState.ENDED)) {
            throw new InvalidGameStateForActionException("game has already ended");
        }
        System.out.println("Adding player " + player.toString());
        this.players.add(player);
        this.playerLocations.put(player, new Point(0, 0));
    }

    @Override
    public void removePlayer(Player player) {
        if (gameState.equals(GameState.STARTED))
            throw new InvalidGameStateForActionException("can't remove player mid game");
        else if (gameState.equals(GameState.ENDED)) {
            throw new InvalidGameStateForActionException("game has already ended");
        }
        if (!playerLocations.containsKey(player)) {
            throw new InvalidGamePlayerException("this player was not registered for this game");
        }
        this.players.remove(player);
        this.playerLocations.remove(player);
    }

    @Override
    public Player getPlayerWithTurn() {
        return players.get(playerWithTurn);
    }

    @Override
    public boolean isMoveValid(Move obj) {
        SnakeLadderMove move = (SnakeLadderMove) obj;
        Point location = playerLocations.get(getPlayerWithTurn()); // current player's location
        return (location.getY() != boardHeight - 1)
                || (location.getX() <= boardWidth - move.getRoll());
    }

    private boolean checkPlayerAtWinningCell(Point playerLocation) {
        return playerLocation.getX() == boardWidth - 1
                && playerLocation.getY() == boardHeight;
    }

    @Override
    public void makeMove(Move move) {
        if (!isMoveValid(move)) {
            throw new InvalidMoveException("move is not valid");
        }
        System.out.println("Making the move " + move.toString());
        int roll = ((SnakeLadderMove) move).getRoll();
        Player player = getPlayerWithTurn();
        Point location = playerLocations.get(player);
        Point newLocation = new Point(
                (int) ((location.getX() + roll) % boardWidth),
                (int) (location.getY() + ((location.getX() + roll) > boardWidth ? 1 : 0))
        );
        playerLocations.put(player, newLocation);
        if (checkPlayerAtWinningCell(newLocation)) {
            // the current player has won the game!
            gameState = GameState.ENDED;
        } else {
            // make sure that the turn is advanced
            playerWithTurn = turnTracker.getNext();
        }
        // notify all my players
        for (Player p : players) {
            p.notifyMoveMade(move);
        }
    }

    @Override
    public boolean isADraw() {
        return false;
    }

    @Override
    public GameStats getWinningPlayerStats() {
        if (gameState.equals(GameState.ENDED))
            return new SnakeLadderGameStats(players.get(playerWithTurn));
        else
            throw new InvalidGameStateForActionException("Game in progress: winner hasn't been decided yet");
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    public static class Builder {
        private int snakes, ladders, boardWidth, boardHeight;
        private List<Player> players;

        public Builder() {
        }

        public Builder snakes(int snakes) {
            this.snakes = snakes;
            return this;
        }

        public Builder ladders(int ladders) {
            this.ladders = ladders;
            return this;
        }

        public Builder boardWidth(int boardWidth) {
            this.boardWidth = boardWidth;
            return this;
        }

        public Builder boardHeight(int boardHeight) {
            this.boardHeight = boardHeight;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public SnakeLadderGame build() {
            if (boardWidth < 3 || boardHeight < 3) {
                throw new InvalidBoardSizeException("Board size should be atleast 3x3");
            }
            return new SnakeLadderGame(this);
        }
    }
}


// Publisher Subscriber
// Observer => Events