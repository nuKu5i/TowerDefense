package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class GameStage extends Application {
    public static Scene sceneStart, sceneField, sceneExit, sceneWin;
    GraphicsContext graphicsContext;

    private MediaPlayer waitScreen;
    private MediaPlayer inGame;
    public static Label labelHealth = new Label("health");
    public static Label labelCoin = new Label("coin");


    public static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        AnchorPane startMenu = new AnchorPane();// màn hình Start
        AnchorPane gameOver = new AnchorPane();// màn hình GameOver
        AnchorPane gameWin = new AnchorPane();// màn hình WinGame
        AnchorPane root = new AnchorPane();// màn hình gameField

        ImageView bg_menu = new ImageView(new Image("file:out/PNG/bg_menu.jpeg"));
        bg_menu.setFitWidth(Config.SCREEN_WIDTH);
        bg_menu.setFitHeight(Config.SCREEN_HEIGHT);

        Button buttonStart = new Button("Play");
        buttonStart.setStyle("-fx-background-color: red;-fx-pref-height: 50px; -fx-pref-width: 100px; -fx-font-size:23;");
        AnchorPane.setTopAnchor(buttonStart, (double)Config.SCREEN_HEIGHT - 250);
        AnchorPane.setLeftAnchor(buttonStart, (double)Config.SCREEN_WIDTH/2 - 50);


        Button buttonExit = new Button("Exit");
        buttonExit.setStyle("-fx-background-color: red;-fx-pref-height: 50px; -fx-pref-width: 100px; -fx-font-size:23;");
        AnchorPane.setTopAnchor(buttonExit, (double)Config.SCREEN_HEIGHT - 180);
        AnchorPane.setLeftAnchor(buttonExit, (double)Config.SCREEN_WIDTH/2 - 50);

        ImageView imageView_Win = new ImageView(new Image("file:out/PNG/bg_menu.png"));
        Button buttonWin = new Button("You win");
        buttonWin.setStyle("-fx-background-color: red;-fx-pref-height: 100px; -fx-pref-width: 200px; -fx-font-size:50;");
        AnchorPane.setTopAnchor(buttonWin, 350.0);
        AnchorPane.setLeftAnchor(buttonWin, (double)Config.SCREEN_WIDTH/2 -100);

        ImageView imageView_Exit = new ImageView(new Image("file:out/PNG/bg_menu.png"));
        Button buttonLose = new Button("You lose");
        buttonLose.setStyle("-fx-background-color: red;-fx-pref-height: 100px; -fx-pref-width: 200px; -fx-font-size:50;");
        AnchorPane.setTopAnchor(buttonLose, 350.0);
        AnchorPane.setLeftAnchor(buttonLose, (double)Config.SCREEN_WIDTH/2 - 100);

        Image image_health = new Image("file:out/PNG/health.png");
        Image image_gold = new Image("file:out/PNG/coin.png");

        ImageView imageView_health = new ImageView(image_health);
        imageView_health.setFitWidth(20);
        imageView_health.setFitHeight(20);
        ImageView imageView_gold = new ImageView(image_gold);
        imageView_gold.setFitWidth(20);
        imageView_gold.setFitHeight(20);

        AnchorPane.setTopAnchor(labelHealth, 20.0);
        AnchorPane.setLeftAnchor(labelHealth, (double)Config.SCREEN_WIDTH - 150 + 50);
        AnchorPane.setTopAnchor(imageView_health, 20.0);
        AnchorPane.setLeftAnchor(imageView_health, (double)Config.SCREEN_WIDTH - 150 + 10);
        
        AnchorPane.setTopAnchor(labelCoin, 50.0);
        AnchorPane.setLeftAnchor(labelCoin, (double)Config.SCREEN_WIDTH - 150 + 50);
        AnchorPane.setTopAnchor(imageView_gold, 50.0);
        AnchorPane.setLeftAnchor(imageView_gold, (double)Config.SCREEN_WIDTH - 150 + 10);

        Button buttonNormalTower = new Button("Normal - 100$");
        buttonNormalTower.setId("NormalTower");
        Button buttonMachinegunTower = new Button("MCh.Gun - 200$");
        buttonMachinegunTower.setId("MachineGunTower");
        Button buttonSniperTower = new Button("Sniper - 300$");
        buttonSniperTower.setId("SniperTower");

        AnchorPane.setTopAnchor(buttonNormalTower, 80.0);
        AnchorPane.setLeftAnchor(buttonNormalTower, (double)Config.SCREEN_WIDTH - 150 + 10);

        AnchorPane.setTopAnchor(buttonMachinegunTower, 120.0);
        AnchorPane.setLeftAnchor(buttonMachinegunTower, (double)Config.SCREEN_WIDTH - 150 + 10);

        AnchorPane.setTopAnchor(buttonSniperTower, 160.0);
        AnchorPane.setLeftAnchor(buttonSniperTower, (double)Config.SCREEN_WIDTH - 150 + 10);


        Button buttonPA = new Button("PlayAgain");
        buttonPA.setStyle("-fx-background-color: yellow;");
        AnchorPane.setTopAnchor(buttonPA, 200.0);
        AnchorPane.setLeftAnchor(buttonPA, (double)Config.SCREEN_WIDTH - 150 + 10);

        Button buttonSell = new Button("Sell");
        buttonSell.setStyle("-fx-background-color: green;");
        AnchorPane.setTopAnchor(buttonSell, 250.0);
        AnchorPane.setLeftAnchor(buttonSell, (double)Config.SCREEN_WIDTH - 150 + 10);

        Button buttonUpgrade = new Button("Upgrade");
        buttonUpgrade.setStyle("-fx-background-color: green;");
        AnchorPane.setTopAnchor(buttonUpgrade, 300.0);
        AnchorPane.setLeftAnchor(buttonUpgrade, (double)Config.SCREEN_WIDTH - 150 + 10);

        Canvas canvas = new Canvas(Config.SCREEN_WIDTH - 150.0, Config.SCREEN_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GameField gameField = new GameField(graphicsContext);
        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        root.getChildren().addAll(buttonNormalTower, buttonMachinegunTower, buttonSniperTower, canvas, imageView_health, imageView_gold, labelCoin, labelHealth, buttonPA,buttonSell,buttonUpgrade);

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameField.MouseHandling(event);
            }
        });
        sceneField = new Scene(root, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        
        /********XU LY CLICK CAC BUTTON********/
        
        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playMusicInGame();
                window.setScene(sceneField);
                window.show();
                gameField.restart();
                gameField.start();
            }
        });
        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneStart);
                window.show();
            }
        });
        buttonNormalTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameField.actionTower(event);
            }
        });

        buttonMachinegunTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameField.actionTower(event);
            }
        });
        buttonSniperTower.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameField.actionTower(event);
            }
        });
        buttonSell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameField.actionTower(event);
            }
        });
        buttonUpgrade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameField.actionTower(event);
            }
        });
        buttonPA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneStart);
                gameField.restartGame();
                window.show();
            }
        });
        

        gameOver.getChildren().addAll(imageView_Exit, buttonExit);
        startMenu.getChildren().addAll(bg_menu, buttonStart,buttonExit);
        gameWin.getChildren().addAll(imageView_Win,buttonWin);
        sceneWin = new Scene(gameWin, Config.SCREEN_WIDTH , Config.SCREEN_HEIGHT);
        sceneStart = new Scene(startMenu, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        sceneExit = new Scene(gameOver, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        window.setScene(sceneStart);
        window.setResizable(false);
        window.setTitle(Config.GAME_NAME);
        playTheme();
        window.show();
    }

    public void playTheme(){
        try{
            Media media = new Media(getClass().getResource("file:/SND/menu.mp3").toURI().toString());
            waitScreen = new MediaPlayer(media);
            waitScreen.setAutoPlay(true);
            waitScreen.setVolume(1);
        }
        catch (Exception e){};
    }

    public void playMusicInGame(){
        try{
            Media media = new Media(getClass().getResource("file:/SND/theme.mp3").toURI().toString());
            inGame = new MediaPlayer(media);
            inGame.setAutoPlay(true);
            inGame.setVolume(0.1);
        }
        catch (Exception e){};
    }


    public static void main(String[] args) {
        launch(args);
    }
}
