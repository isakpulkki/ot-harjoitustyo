package pong.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import pong.controls.Settings;
import pong.game.GameLogic;


public class PongScene {

    Stage stage;
    Settings settings;
    public int height;
    public int width;
    public String style;
    public Font font;

    public PongScene(Stage stage, Settings settings) {
        this.stage = stage;
        this.settings = settings;
        height = settings.getHeight();
        width = settings.getWidth();
        style = settings.getStyle();
        font = settings.getFont();
    }

    public void getPongScene() {
        Canvas canvas = new Canvas(width, height);
        canvas.setFocusTraversable(true);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                stage.setScene(new MenuScene(stage, settings).getMenuScene());
                stage.show();
            }
        });
        GameLogic gameLogic = new GameLogic(height, width, settings);
        KeyFrame keyframe = new KeyFrame(Duration.millis(10), e -> gameLogic.getGraphics(graphicsContext));
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        BorderPane borderPane = new BorderPane(canvas);
        borderPane.setStyle(style);
        timeline.play();
        stage.setScene(new Scene(borderPane, width, height));
        stage.show();
    }


}
