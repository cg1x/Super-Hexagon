package game.superhexagon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        BrightnessAdjuster adjuster = new BrightnessAdjuster();
        Color color = Color.CYAN;
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        Background background = new Background(root, color);
        Hexagon hexagon = new Hexagon(root, color);
        Player player = new Player(root, color);
        Obstacle obstacle = new Obstacle(root, color);
        Controller controller = new Controller(player);
        GameLoop gameLoop = new GameLoop(hexagon, background, player, controller, obstacle);


        scene.setOnKeyPressed(controller::handleKeyPress);
        scene.setOnKeyReleased(controller::handleKeyRelease);

        stage.setTitle("Super Hexagon");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        gameLoop.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}