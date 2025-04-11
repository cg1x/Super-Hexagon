package game.superhexagon;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    public Hexagon hexagon;
    public Background background;
    public Player player;
    public Obstacle obstacle;
    public Controller controller;
    public double rotationSpeed = 0.5;
    public double playerSpeed = 2;
    public double obstacleSpeed = 0.8;

    public GameLoop(Hexagon hexagon, Background background, Player player, Controller controller, Obstacle obstacle) {
        this.hexagon = hexagon;
        this.background = background;
        this.player = player;
        this.obstacle = obstacle;
        this.controller = controller;
    }
    @Override
    public void handle(long l) {
        hexagon.rotate(rotationSpeed);
        background.rotate(rotationSpeed);
        player.rotate(rotationSpeed);
        obstacle.rotate(rotationSpeed);
        obstacle.move(-obstacleSpeed);
        if (controller.isMovingLeft()) {
            player.move(-playerSpeed);
        }
        if (controller.isMovingRight()) {
            player.move(playerSpeed + 2 * rotationSpeed);
        }
    }
}
