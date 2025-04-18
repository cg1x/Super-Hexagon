package game.superhexagon;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameLoop extends AnimationTimer {
    public Hexagon hexagon;
    public Background background;
    public Player player;
    public List<Obstacle> obstacles = new ArrayList<>();
    public Controller controller;
    public double startTime;
    public Text timer;
    public Game game;
    public double rotationSpeed = 0.75;
    public double playerSpeed = 1.5;
    public double obstacleSpeed = 1;
    public boolean firstTime = true;
    public double surviveTime;

    public GameLoop(Hexagon hexagon, Background background, Player player, Controller controller,
                    Obstacle obstacle, Text timer, Game game) {
        this.hexagon = hexagon;
        this.background = background;
        this.player = player;
        this.obstacles.add(obstacle);
        this.controller = controller;
        this.timer = timer;
        this.startTime = System.nanoTime();
        this.game = game;
    }
    @Override
    public void handle(long l) {
        double elapsedTime = (l - startTime) / 1_000_000_000.0;
        timer.setText(String.format("TIME: %.2f", elapsedTime));
        hexagon.rotate(rotationSpeed);
        background.rotate(rotationSpeed);
        player.rotate(rotationSpeed);
        if (obstacles.size() % 5 == 0) {
            if (firstTime) {
                playerSpeed += 0.1;
                obstacleSpeed += 0.1;
                firstTime = false;
            }
        }
        else firstTime = true;
        for (Obstacle obstacle : obstacles) {
            if (collided(obstacle)) {
                stop();
                surviveTime = elapsedTime;
                game.showGameOver();
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
        updateColor();
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

    public void updateColor() {
        hexagon.updateColor();
        background.updateColor();
        player.updateColor();
        for (Obstacle obstacle : obstacles) {
            obstacle.updateColor();
        }
    }
}
