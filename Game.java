package game.superhexagon;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
    public Stage stage;
    public GameLoop gameLoop;

    public Game(Stage stage) {
        this.stage = stage;
    }

    public void showLogin() {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        Background background = new Background(root);
        Polygon blackBox = new Polygon();
        blackBox.getPoints().addAll(
                200.0, 200.0,
                200.0, 600.0,
                600.0, 600.0,
                600.0, 200.0
        );
        blackBox.setFill(Color.BLACK);
        root.getChildren().add(blackBox);

        Label nameLabel = new Label("ENTER YOUR NAME:");
        nameLabel.setTextFill(Color.RED);
        nameLabel.setFont(new Font("Verdana", 24));
        nameLabel.setLayoutX(300.0);
        nameLabel.setLayoutY(300.0);
        root.getChildren().add(nameLabel);

        TextField nameField = new TextField();
        nameField.setPrefWidth(200);
        nameField.setPrefHeight(50);
        nameField.setLayoutX(320);
        nameField.setLayoutY(375);
        nameField.setFont(new Font("Verdana", 18));
        root.getChildren().add(nameField);

        Button loginButton = new Button("LOGIN");
        loginButton.setPrefWidth(80);
        loginButton.setPrefHeight(30);
        loginButton.setLayoutX(370);
        loginButton.setLayoutY(460);
        loginButton.setFont(new Font("Verdana", 12));
        loginButton.setOnAction(e -> showMenu());
        root.getChildren().add(loginButton);

        Button exitButton = new Button("EXIT");
        exitButton.setPrefWidth(80);
        exitButton.setPrefHeight(30);
        exitButton.setLayoutX(370);
        exitButton.setLayoutY(510);
        exitButton.setFont(new Font("Verdana", 12));
        exitButton.setOnAction(e -> Platform.exit());
        root.getChildren().add(exitButton);

        stage.setTitle("Super Hexagon");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void showMenu() {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        Background background = new Background(root);
        Polygon blackBox = new Polygon();
        blackBox.getPoints().addAll(
                200.0, 200.0,
                200.0, 600.0,
                600.0, 600.0,
                600.0, 200.0
        );
        blackBox.setFill(Color.BLACK);
        root.getChildren().add(blackBox);

        Polygon bestTimeBox = new Polygon();
        bestTimeBox.getPoints().addAll(
                0.0, 0.0,
                0.0, 40.0,
                180.0, 40.0,
                210.0, 0.0
        );
        bestTimeBox.setFill(Color.BLACK);
        root.getChildren().add(bestTimeBox);
        Text bestTime = new Text("BEST: 131.51");
        bestTime.setFill(Color.WHITE);
        bestTime.setFont(new Font("Verdana",24));
        bestTime.setX(10);
        bestTime.setY(30);
        root.getChildren().add(bestTime);

        Button startButton = new Button("START GAME");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(50);
        startButton.setLayoutX(300);
        startButton.setLayoutY(250);
        startButton.setFont(new Font("Verdana", 16));
        startButton.setOnAction(e -> startGame());
        root.getChildren().add(startButton);

        Button historyButton = new Button("GAME HISTORY");
        historyButton.setPrefWidth(200);
        historyButton.setPrefHeight(50);
        historyButton.setLayoutX(300);
        historyButton.setLayoutY(330);
        historyButton.setFont(new Font("Verdana", 16));
        root.getChildren().add(historyButton);

        Button settingsButton = new Button("SETTINGS");
        settingsButton.setPrefWidth(200);
        settingsButton.setPrefHeight(50);
        settingsButton.setLayoutX(300);
        settingsButton.setLayoutY(410);
        settingsButton.setFont(new Font("Verdana", 16));
        root.getChildren().add(settingsButton);

        Button exitButton = new Button("EXIT");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);
        exitButton.setLayoutX(300);
        exitButton.setLayoutY(490);
        exitButton.setFont(new Font("Verdana", 16));
        exitButton.setOnAction(e -> Platform.exit());
        root.getChildren().add(exitButton);

        stage.setTitle("Super Hexagon");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void showGameOver() {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 800, Color.BLACK);

        Background background = new Background(root);
        Polygon blackBox = new Polygon();
        blackBox.getPoints().addAll(
                200.0, 200.0,
                200.0, 600.0,
                600.0, 600.0,
                600.0, 200.0
        );
        blackBox.setFill(Color.BLACK);
        root.getChildren().add(blackBox);

        Polygon bestTimeBox = new Polygon();
        bestTimeBox.getPoints().addAll(
                0.0, 0.0,
                0.0, 40.0,
                180.0, 40.0,
                210.0, 0.0
        );
        bestTimeBox.setFill(Color.BLACK);
        root.getChildren().add(bestTimeBox);
        Text bestTime = new Text("BEST: 131.51");
        bestTime.setFill(Color.WHITE);
        bestTime.setFont(new Font("Verdana",24));
        bestTime.setX(10);
        bestTime.setY(30);
        root.getChildren().add(bestTime);

        Text surviveTime = new Text(String.format("YOU SURVIVED %.2f", gameLoop.surviveTime) + "s");
        surviveTime.setFill(Color.RED);
        surviveTime.setFont(new Font("Verdana",26));
        surviveTime.setX(260);
        surviveTime.setY(275);
        root.getChildren().add(surviveTime);

        Button playAgainButton = new Button("PLAY AGAIN");
        playAgainButton.setPrefWidth(200);
        playAgainButton.setPrefHeight(50);
        playAgainButton.setLayoutX(300);
        playAgainButton.setLayoutY(330);
        playAgainButton.setFont(new Font("Verdana", 16));
        playAgainButton.setOnAction(e -> startGame());
        root.getChildren().add(playAgainButton);

        Button backButton = new Button("BACK TO MENU");
        backButton.setPrefWidth(200);
        backButton.setPrefHeight(50);
        backButton.setLayoutX(300);
        backButton.setLayoutY(410);
        backButton.setFont(new Font("Verdana", 16));
        backButton.setOnAction(e -> showMenu());
        root.getChildren().add(backButton);

        stage.setTitle("Super Hexagon");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(800);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void startGame() {
        Pane root = new Pane();
        Pane boxes = new Pane();
        Pane mainRoot = new Pane(root, boxes);
        Color color = Color.hsb(0, 1, 1);
        Scene scene = new Scene(mainRoot, 800, 800, Color.BLACK);

        Background background = new Background(root);
        Hexagon hexagon = new Hexagon(root);
        Player player = new Player(root);
        Obstacle obstacle = new Obstacle(root, color);
        Controller controller = new Controller(player);
        Polygon timerBox = new Polygon();
        timerBox.getPoints().addAll(
                800.0, 0.0,
                800.0, 40.0,
                630.0, 40.0,
                600.0, 0.0
        );
        timerBox.setFill(Color.BLACK);
        boxes.getChildren().add(timerBox);
        Text timer = new Text("TIME: 0.00");
        timer.setFill(Color.WHITE);
        timer.setFont(new Font("Verdana",24));
        timer.setX(635);
        timer.setY(30);
        boxes.getChildren().add(timer);

        Polygon bestTimeBox = new Polygon();
        bestTimeBox.getPoints().addAll(
                0.0, 0.0,
                0.0, 40.0,
                180.0, 40.0,
                210.0, 0.0
        );
        bestTimeBox.setFill(Color.BLACK);
        boxes.getChildren().add(bestTimeBox);
        Text bestTime = new Text("BEST: 131.51");
        bestTime.setFill(Color.WHITE);
        bestTime.setFont(new Font("Verdana",24));
        bestTime.setX(10);
        bestTime.setY(30);
        boxes.getChildren().add(bestTime);

        Polygon pauseBox = new Polygon();
        pauseBox.getPoints().addAll(
                0.0, 800.0,
                0.0, 760.0,
                150.0, 760.0,
                180.0, 800.0
        );
        pauseBox.setFill(Color.BLACK);
        boxes.getChildren().add(pauseBox);
        Text pauseText = new Text("PAUSE [P]");
        pauseText.setFill(Color.WHITE);
        pauseText.setFont(new Font("Verdana",24));
        pauseText.setX(15);
        pauseText.setY(790);
        boxes.getChildren().add(pauseText);

        Polygon resumeBox = new Polygon();
        resumeBox.getPoints().addAll(
                800.0, 800.0,
                800.0, 760.0,
                640.0, 760.0,
                610.0, 800.0
        );
        resumeBox.setFill(Color.BLACK);
        boxes.getChildren().add(resumeBox);
        Text reaumeText = new Text("RESUME [R]");
        reaumeText.setFill(Color.WHITE);
        reaumeText.setFont(new Font("Verdana",24));
        reaumeText.setX(645);
        reaumeText.setY(790);
        boxes.getChildren().add(reaumeText);

        Polygon backBox = new Polygon();
        backBox.getPoints().addAll(
                300.0, 800.0,
                330.0, 760.0,
                470.0, 760.0,
                500.0, 800.0
        );
        backBox.setFill(Color.BLACK);
        boxes.getChildren().add(backBox);
        Text backText = new Text("BACK [B]");
        backText.setFill(Color.WHITE);
        backText.setFont(new Font("Verdana",24));
        backText.setX(345);
        backText.setY(790);
        boxes.getChildren().add(backText);

        gameLoop = new GameLoop(hexagon, background, player, controller, obstacle, timer, this);

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
}
