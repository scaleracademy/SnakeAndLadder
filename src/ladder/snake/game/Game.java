package ladder.snake.game;

import ladder.snake.game.players.Player;

public interface Game {
    void initialize();

    void addPlayer(Player player);

    void removePlayer(Player player);

    default boolean isOver() {
        return this.getGameState().equals(GameState.ENDED);
    }

    Player getPlayerWithTurn();

    boolean isMoveValid(Move move);

    void makeMove(Move move);

    boolean isADraw();

    GameStats getWinningPlayerStats();

    GameState getGameState();
}
