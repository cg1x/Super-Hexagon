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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Color color = Color.hsb(0, 1, 1);
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        Background background = new Background(root);
        Hexagon hexagon = new Hexagon(root);
        Player player = new Player(root);
        Obstacle obstacle = new Obstacle(root, color);
        Controller controller = new Controller(player);
        Polygon timerBox = new Polygon();
        timerBox.getPoints().addAll(
                0.0, 0.0,
                0.0, 40.0,
                160.0, 40.0,
                190.0, 0.0
        );
        timerBox.setFill(Color.BLACK);
        root.getChildren().add(timerBox);
        Text timer = new Text("TIME: 0.00");
        timer.setFill(Color.WHITE);
        timer.setFont(new Font("Verdana",24));
        timer.setX(10);
        timer.setY(30);
        root.getChildren().add(timer);
        GameLoop gameLoop = new GameLoop(hexagon, background, player, controller, obstacle, timer);

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