package pong.ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import pong.controls.Settings;
import pong.game.GameUi;

import java.io.FileNotFoundException;


public class PongScene extends Settings {

    Stage stage;

    public PongScene(Stage stage) {
        this.stage = stage;
    }

    public void getPongScene() {
        Canvas canvas = new Canvas(width, height);
        canvas.setFocusTraversable(true);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        GameUi gameUi = new GameUi(graphicsContext);
        KeyFrame keyframe = new KeyFrame(Duration.millis(8), e -> {
            try {
                gameUi.getGraphics();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        setKeyListeners(gameUi, canvas, timeline);
        StackPane stackPane = new StackPane(canvas);
        stackPane.setStyle(style);
        stage.setScene(new Scene(stackPane));
        stage.show();
        timeline.play();
    }

    public void setKeyListeners(GameUi gameUi, Canvas canvas, Timeline timeline) {
        canvas.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                timeline.stop();
                stage.setScene(new MenuScene(stage).getMenuScene());
                stage.show();
            }
            if (e.getCode() == KeyCode.DOWN) {
                gameUi.getGameLogic().setDownPressed(true);
            }
            if (e.getCode() == KeyCode.UP) {
                gameUi.getGameLogic().setUpPressed(true);
            }
            if (e.getCode() == KeyCode.S) {
                gameUi.getGameLogic().setsPressed(true);
            }
            if (e.getCode() == KeyCode.W) {
                gameUi.getGameLogic().setwPressed(true);
                gameUi.getGameLogic().setGameStarted(true);
            }
        });
        canvas.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                gameUi.getGameLogic().setDownPressed(false);
            }
            if (e.getCode() == KeyCode.UP) {
                gameUi.getGameLogic().setUpPressed(false);
            }
            if (e.getCode() == KeyCode.S) {
                gameUi.getGameLogic().setsPressed(false);
            }
            if (e.getCode() == KeyCode.W) {
                gameUi.getGameLogic().setwPressed(false);
            }
        });
    }


}
