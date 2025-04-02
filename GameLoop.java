package game.superhexagon;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
    public Hexagon hexagon;
    public Background background;
    public Player player;
    public double rotationSpeed = 0.5;

    public GameLoop(Hexagon hexagon, Background background, Player player) {
        this.hexagon = hexagon;
        this.background = background;
        this.player = player;
    }
    @Override
    public void handle(long l) {
        hexagon.rotate(rotationSpeed);
        background.rotate(rotationSpeed);
        player.rotate(rotationSpeed);
    }
}
