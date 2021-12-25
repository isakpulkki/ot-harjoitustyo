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
import pong.data.Config;
import pong.game.Ui;

import java.io.FileNotFoundException;

/**
* Makes the Game -scene in the application
 */

public class Pong extends Config {

    Stage stage;

    public Pong(Stage stage) {
        this.stage = stage;
    }
/**
* this put's the game scene to the JavaFX stage
 */
    public void getPongScene() {
        Canvas canvas = new Canvas(width, height);
        canvas.setFocusTraversable(true);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Ui ui = new Ui(graphicsContext);
        KeyFrame keyframe = new KeyFrame(Duration.millis(15), e -> {
            try {
                ui.getGraphics();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        setKeyListeners(ui, canvas, timeline);
        StackPane stackPane = new StackPane(canvas);
        stackPane.setStyle(style);
        stage.setScene(new Scene(stackPane));
        stage.show();
        timeline.play();
    }
/**
* Makes key listeners for the player, to use in game
 */
    public void setKeyListeners(Ui ui, Canvas canvas, Timeline timeline) {
        canvas.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                timeline.stop();
                stage.setScene(new Menu(stage).getMenuScene());
                stage.show();
            }
            if (e.getCode() == KeyCode.DOWN) {
                ui.getGameLogic().setDownPressed(true);
            }
            if (e.getCode() == KeyCode.UP) {
                ui.getGameLogic().setUpPressed(true);
            }
            if (e.getCode() == KeyCode.S) {
                ui.getGameLogic().setsPressed(true);
            }
            if (e.getCode() == KeyCode.W) {
                ui.getGameLogic().setwPressed(true);
            }
            ui.getGameLogic().setGameStarted(true);
        });
        canvas.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DOWN) {
                ui.getGameLogic().setDownPressed(false);
            }
            if (e.getCode() == KeyCode.UP) {
                ui.getGameLogic().setUpPressed(false);
            }
            if (e.getCode() == KeyCode.S) {
                ui.getGameLogic().setsPressed(false);
            }
            if (e.getCode() == KeyCode.W) {
                ui.getGameLogic().setwPressed(false);
            }
        });
    }


}
