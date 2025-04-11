package game.superhexagon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

import java.lang.Math;

public class Trapezoid {
    public Polygon trapezoid;
    public final double centerX = 400;
    public final double centerY = 400;
    public Rotate obstacleRotate = new Rotate(0, centerX, centerY);
    public double radius = 500;
    public double thickness = 30;

    public Trapezoid(Pane root, Color color, double angle) {
        trapezoid = new Polygon();
        double angle1 = Math.toRadians(angle);
        double angle2 = Math.toRadians(angle + 60);
        trapezoid.getPoints().addAll(
                centerX + radius * Math.cos(angle1), centerY + radius * Math.sin(angle1),
                centerX + (radius + thickness) * Math.cos(angle1), centerY + (radius + thickness) * Math.sin(angle1),
                centerX + (radius + thickness) * Math.cos(angle2), centerY + (radius + thickness) * Math.sin(angle2),
                centerX + radius * Math.cos(angle2), centerY + radius * Math.sin(angle2)
        );
        trapezoid.setFill(color);
        trapezoid.getTransforms().add(obstacleRotate);
        root.getChildren().add(trapezoid);
    }

    public void updateColor(double hue) {
        trapezoid.setFill(Color.hsb(hue, 1, 1));
    }

    public boolean readyForNext() {
        double x = trapezoid.getPoints().get(0) - centerX;
        double y = trapezoid.getPoints().get(1) - centerY;
        double distance = Math.sqrt((x * x) + (y * y));

        if (distance < radius * 2 / 3) {
            double angle = obstacleRotate.getAngle();
            return angle % 60 == 0;
        }

        return false;
    }

    public void move(double speed) {
        double hexagonRadius = 50;
        for (int i = 0; i < 8; i += 2) {
            double x = trapezoid.getPoints().get(i) - centerX;
            double y = trapezoid.getPoints().get(i + 1) - centerY;
            double distance = Math.sqrt((x * x) + (y * y));
            if (distance > hexagonRadius) {
                trapezoid.getPoints().set(i, centerX + x + (x / distance) * speed);
                trapezoid.getPoints().set(i + 1, centerY + y + (y / distance) * speed);
            }
        }
    }

    public void rotate(double angle) {
        obstacleRotate.setAngle(obstacleRotate.getAngle() - angle);
    }
}
