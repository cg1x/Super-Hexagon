package game.superhexagon;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class GameLoop extends AnimationTimer {
    public Hexagon hexagon;
    public Background background;
    public Player player;
    public List<Obstacle> obstacles = new ArrayList<>();
    public Controller controller;
    public double rotationSpeed = 0.5;
    public double playerSpeed = 2;
    public double obstacleSpeed = 0.8;

    public GameLoop(Hexagon hexagon, Background background, Player player, Controller controller, Obstacle obstacle) {
        this.hexagon = hexagon;
        this.background = background;
        this.player = player;
        obstacles.add(obstacle);
        this.controller = controller;
    }
    @Override
    public void handle(long l) {
        hexagon.rotate(rotationSpeed);
        background.rotate(rotationSpeed);
        player.rotate(rotationSpeed);
        for (Obstacle obstacle : obstacles) {
            if (collided(obstacle)) {
                stop();
            }
            obstacle.rotate(rotationSpeed);
            obstacle.move(-obstacleSpeed);
        }
        if (obstacles.getLast().readyForNext()) {
            obstacles.getLast().update(obstacles);
        }
        if (controller.isMovingLeft()) {
            player.move(-playerSpeed);
        }
        if (controller.isMovingRight()) {
            player.move(playerSpeed + 2 * rotationSpeed);
        }
    }

    public boolean collided(Obstacle obstacle) {
        boolean result = false;
        for (Trapezoid trapezoid : obstacle.obstacles) {
            Shape shape = Shape.intersect(player.triangle, trapezoid.trapezoid);
            if (shape.getBoundsInLocal().getWidth() != -1)
                    result = true;
        }
        return result;
    }
}
