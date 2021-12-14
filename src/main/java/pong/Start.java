package pong;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pong.controls.Settings;
import pong.ui.Menu;

/**
This method launches the game, and sets MenuScene as the first scene
 */

public class Start extends Application {

    public Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes the stage
     * @param stage, with this you can show the scenes
     */

    public void start(Stage stage) {
        stage.setTitle("Pong Game");
        stage.setResizable(false);
        stage.setMaximized(false);
        Menu menu = new Menu(stage);
        stage.setScene(menu.getMenuScene());
        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                stage.setScene(new Menu(stage).getMenuScene());
                stage.show();
            }
        });
        this.stage = stage;
        stage.show();
    }
}
