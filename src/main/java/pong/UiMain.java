package pong;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UiMain extends Application {
    public Button exit;
    public Button settings;
    public Button start;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        makeButtons();
        stage.setTitle("Pong Game");
        stage.setResizable(false);
        stage.setMaximized(false);

        stage.setScene(this.getMenuScene());
        stage.show();
    }

    public void makeButtons(){
        this.start = new Button("Pelaa");
        this.start.setOnMousePressed(e -> {
        });
        this.settings = new Button("Asetukset");
        this.settings.setOnMousePressed(e -> {
        });
        this.exit = new Button("Poistu");
        this.exit.setOnMousePressed(e -> {
            System.exit(0);
        });
    }

    public Scene getMenuScene() {
        BorderPane borderPane = new BorderPane();
        VBox buttons = new VBox();
        buttons.getChildren().addAll(this.start,
                this.settings,
                this.exit);

        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        borderPane.setCenter(buttons);
        return new Scene(borderPane, 500, 500);
    }
}
