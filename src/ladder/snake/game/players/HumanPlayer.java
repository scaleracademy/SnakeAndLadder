package ladder.snake.game.players;

import ladder.snake.Audience;
import ladder.snake.User;
import ladder.snake.game.Move;
import ladder.snake.games.snakeladder.SnakeLadderMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player {
    private User user;
    private String symbol;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public HumanPlayer(User user, String symbol) {
        this.user = user;
        this.symbol = symbol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Move generateMove() {
        int roll = 0;
        try{
            System.out.println("Dear " + user.getName() + " please roll the dice: ");
            roll = Integer.parseInt(br.readLine());
        } catch (IOException ignored) {}

        System.out.println(this.toString() + " and I rolled a " + roll);
        return new SnakeLadderMove(roll);
    }

    @Override
    public void notifyMoveMade(Move move) {
        System.out.println("Hi, I'm " + user.getName() + " and I observed the move " + move);
    }

    @Override
    public String toString() {
        return "hi, I'm " + user.getName();
    }
}
