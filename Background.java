package game.superhexagon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Background {
    public Polygon[] sections = new Polygon[6];

    public Background(Pane root, Color color) {
        double sideLength = 650;
        BrightnessAdjuster adjuster = new BrightnessAdjuster();

        for (int i = 0; i < 6; i++) {
            double angle1 = Math.toRadians(i * 60);
            double angle2 = Math.toRadians((i + 1) * 60);

            double x1 = 400 + sideLength * Math.cos(angle1);
            double y1 = 400 + sideLength * Math.sin(angle1);
            double x2 = 400 + sideLength * Math.cos(angle2);
            double y2 = 400 + sideLength * Math.sin(angle2);

            sections[i] = new Polygon(
                    400, 400,
                    x1, y1,
                    x2, y2
            );
            if (i % 2 == 0)
                sections[i].setFill(adjuster.newBrightness(color, 0.2));
            else
                sections[i].setFill(adjuster.newBrightness(color, 0.3));
            root.getChildren().add(sections[i]);
        }
    }
}
