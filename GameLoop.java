package game.superhexagon;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    public Hexagon hexagon;
    public Background background;
    public Player player;
    private Controller controller;
    public double rotationSpeed = 0.5;
    public double movementSpeed = 2;

    public GameLoop(Hexagon hexagon, Background background, Player player, Controller controller) {
        this.hexagon = hexagon;
        this.background = background;
        this.player = player;
        this.controller = controller;
    }
    @Override
    public void handle(long l) {
        hexagon.rotate(rotationSpeed);
        background.rotate(rotationSpeed);
        player.rotate(rotationSpeed);
        if (controller.isMovingLeft()) {
            player.move(-movementSpeed);
        }
        if (controller.isMovingRight()) {
            player.move(movementSpeed + 2 * rotationSpeed);
        }
    }
}
