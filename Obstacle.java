package game.superhexagon;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Obstacle {
    public List<Trapezoid> obstacles = new ArrayList<>();

    public Obstacle(Pane root, Color color) {
        int random = (int)(Math.random() * 6);
        for (int i = 0; i < 6; i++) {
            if (i == random) continue;
            Trapezoid trapezoid = new Trapezoid(root, color, i * 60);
            obstacles.add(trapezoid);
        }
    }

    public void move(double speed) {
        for (Trapezoid obstacle : obstacles) {
            obstacle.move(speed);
        }
    }

    public void rotate(double angle) {
        for (Trapezoid obstacle : obstacles) {
            obstacle.rotate(angle);
        }
    }
}
