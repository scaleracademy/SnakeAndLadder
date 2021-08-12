package ladder.snake.games.exceptions.validation;

import ladder.snake.games.exceptions.GameException;

public class ValidationException extends GameException {
    public ValidationException(String message) {
        super(message);
    }
}
