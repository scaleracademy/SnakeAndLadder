package ladder.snake.game.events;

import ladder.snake.game.events.GameEventData;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

public class GameEvent {
    private List<GameEventHandler> handlers;

    public GameEvent() {
        this.handlers = new ArrayList<>();
    }

    public void addListener(GameEventHandler handler) {
        this.handlers.add(handler);
    }

    public void dispatchEvent(GameEventData eventData) {
        for (GameEventHandler hander : handlers) {
            hander.handleEvent(eventData);
        }
    }
}
