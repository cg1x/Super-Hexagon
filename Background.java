package game.superhexagon;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;


public class Background {
    public Polygon[] sections = new Polygon[6];
    public final double centerX = 400;
    public final double centerY = 400;
    public Rotate backGroundRotate = new Rotate(0, centerX, centerY);

    public Background(Pane root, Color color) {
        double sideLength = 650;
        BrightnessAdjuster adjuster = new BrightnessAdjuster();

        for (int i = 0; i < 6; i++) {
            double angle1 = Math.toRadians(i * 60);
            double angle2 = Math.toRadians((i + 1) * 60);

            double x1 = centerX + sideLength * Math.cos(angle1);
            double y1 = centerY + sideLength * Math.sin(angle1);
            double x2 = centerX + sideLength * Math.cos(angle2);
            double y2 = centerY + sideLength * Math.sin(angle2);

            sections[i] = new Polygon(
                    centerX, centerY,
                    x1, y1,
                    x2, y2
            );

            if (i % 2 == 0)
                sections[i].setFill(adjuster.newBrightness(color, 0.2));
            else
                sections[i].setFill(adjuster.newBrightness(color, 0.3));
            root.getChildren().add(sections[i]);
        }

        for (Polygon section : sections) {
            section.getTransforms().add(backGroundRotate);
        }
    }

    public void rotate(double angle) {
            backGroundRotate.setAngle(backGroundRotate.getAngle() - angle);
    }

}
