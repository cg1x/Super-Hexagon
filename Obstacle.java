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
    public Pane root;
    public Color color;

    public Obstacle(Pane root, Color color) {
        int pattern = (int)(Math.random() * 3);

        if (pattern == 0) {
            int random = (int)(Math.random() * 2);
            for (int i = random; i < 6; i+=2) {
                Trapezoid trapezoid = new Trapezoid(root, color, i * 60);
                obstacles.add(trapezoid);
            }
        }

        if (pattern == 1) {
            int random = (int)(Math.random() * 6);
            for (int i = 0; i < 6; i++) {
                if (i == random) continue;
                Trapezoid trapezoid = new Trapezoid(root, color, i * 60);
                obstacles.add(trapezoid);
            }
        }

        if (pattern == 2) {
            int random1 = (int) (Math.random() * 6);
            int random2 = (int) (Math.random() * 6);
            for (int i = 0; i < 6; i++) {
                if (i == random1 || i == random2) continue;
                Trapezoid trapezoid = new Trapezoid(root, color, i * 60);
                obstacles.add(trapezoid);
            }
        }

        this.root = root;
        this.color = color;
    }

    public boolean readyForNext() {
        Trapezoid trapezoid = obstacles.getFirst();
        return trapezoid.readyForNext();
    }

    public void update(List<Obstacle> obstacles) {
        obstacles.add(new Obstacle(root, color));
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
