package game.superhexagon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.lang.Math;

public class Hexagon {
    public Polygon hexagon;

    public Hexagon(Pane root, Color color) {
        hexagon = new Polygon();
        double radius = 50;
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            double x = 400 + radius * Math.cos(angle);
            double y = 400 + radius * Math.sin(angle);
            hexagon.getPoints().addAll(x, y);
        }
        BrightnessAdjuster adjuster = new BrightnessAdjuster();
        hexagon.setFill(adjuster.newBrightness(color, 0.2));
        hexagon.setStroke(color);
        hexagon.setStrokeWidth(4);
        root.getChildren().add(hexagon);
    }

}
