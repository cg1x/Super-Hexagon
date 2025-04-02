package game.superhexagon;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    public Player player;
    public double rotationSpeed = 4;

    public Controller(Player player) {
        this.player = player;
    }

    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT) {
            player.move(-1 * rotationSpeed);
        } else if (event.getCode() == KeyCode.RIGHT) {
            player.move(2 * rotationSpeed);
        }
    }
}
