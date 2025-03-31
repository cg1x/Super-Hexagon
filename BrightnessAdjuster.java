package game.superhexagon;

import javafx.scene.paint.Color;

public class BrightnessAdjuster {
    public Color newBrightness(Color color, double brightness) {
        double hue = color.getHue();
        double saturation = color.getSaturation();
        return Color.hsb(hue, saturation, brightness);
    }
}
