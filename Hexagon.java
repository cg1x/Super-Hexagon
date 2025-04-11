package game.superhexagon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.lang.Math;

public class Hexagon {
    public Polygon hexagon;
    public final double centerX = 400;
    public final double centerY = 400;
    public double hue = 0;

    public Hexagon(Pane root) {
        hexagon = new Polygon();
        double radius = 50;
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            hexagon.getPoints().addAll(x, y);
        }
        hexagon.setFill(Color.hsb(0, 1, 0.2));
        hexagon.setStroke(Color.hsb(0, 1, 1));
        hexagon.setStrokeWidth(4);
        root.getChildren().add(hexagon);
    }

    public void updateColor() {
        hue = hue + 0.1;
        hexagon.setFill(Color.hsb(hue, 1, 0.2));
        hexagon.setStroke(Color.hsb(hue, 1, 1));
    }

    public void rotate(double angle) {
        hexagon.setRotate(hexagon.getRotate() - angle);
    }

}
