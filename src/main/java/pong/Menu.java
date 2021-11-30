package pong;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import pong.controls.Settings;
import pong.ui.MenuScene;

//Käynnistetään toisesta Main-metodista

public class Menu extends Application {

    public Stage stage;
    public Settings settings = new Settings();
    public int height = settings.getHeight();
    public int width = settings.getWidth();
    public String style = settings.getStyle();

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        stage.setTitle("Pong Game");
        stage.setResizable(false);
        stage.setMaximized(false);
        MenuScene menuScene = new MenuScene(stage, settings);
        stage.setScene(menuScene.getMenuScene());
        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                stage.setScene(new MenuScene(stage, settings).getMenuScene());
                stage.show();
            }
        });
        this.stage = stage;
        stage.show();
    }


}
