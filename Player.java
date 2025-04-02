package game.superhexagon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import java.lang.Math;

public class Player {
    public Polygon triangle;
    public final double centerX = 400;
    public final double centerY = 400;
    public Rotate playerRotate = new Rotate(0, centerX, centerY);


    public Player(Pane root, Color color) {
        double sideSize = 15;
        double radius = 60;
        triangle = new Polygon();
        triangle.getPoints().addAll(
                centerX, centerY - radius - (sideSize * Math.cos(Math.PI / 3)),
                centerX - (sideSize / 2), centerY - radius,
                centerX + (sideSize / 2), centerY - radius
        );
        triangle.setFill(color);
        root.getChildren().add(triangle);
        triangle.getTransforms().add(playerRotate);
    }

    public void rotate(double angle) {
        playerRotate.setAngle(playerRotate.getAngle() - angle);
    }

    public void move(double angle) {
        playerRotate.setAngle(playerRotate.getAngle() + angle);
    }
}
