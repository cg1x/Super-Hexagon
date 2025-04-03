package game.superhexagon;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class Controller {
    public Player player;
    private Set<KeyCode> activeKeys = new HashSet<>();
    public double movementSpeed = 8;

    public Controller(Player player) {
        this.player = player;
    }

    public void handleKeyPress(KeyEvent event) {
        activeKeys.add(event.getCode());
    }

    public void handleKeyRelease(KeyEvent event) {
        activeKeys.remove(event.getCode());
    }

    public boolean isMovingLeft() {
        return activeKeys.contains(KeyCode.LEFT);
    }

    public boolean isMovingRight() {
        return activeKeys.contains(KeyCode.RIGHT);
    }
}
