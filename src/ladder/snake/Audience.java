package ladder.snake;

import ladder.snake.game.events.GameEventData;
import ladder.snake.game.events.GameEventHandler;

public class Audience extends User {
    public Audience(String name) {
        super(name);
    }
    public void echoEvent(GameEventData eventData) {
        System.out.println("hi I'm " + getName() + " and I observed the move ");
        System.out.println(eventData.toString());
    }

    public GameEventHandler getGameEventHandler() {
        return this::echoEvent;
    }
}
