package pong.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu extends Application {
    public Button exit;
    public Button settings;
    public Button start;
    public Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        makeButtons();
        stage.setTitle("Pong Game");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setScene(this.MenuScene());
        this.stage = stage;
        stage.show();
    }

    public void makeButtons() {
        MenuButton menuButton = new MenuButton("Pelaa");
        start = menuButton.makeButton();
        start.setOnMouseClicked(e -> this.stage.setScene(new PongScene().getPongScene()));
        menuButton = new MenuButton("Asetukset");
        settings = menuButton.makeButton();
        settings.setOnMouseClicked(e -> this.stage.setScene(new SettingsScene().getSettingsScene()));
        menuButton = new MenuButton("Poistu");
        exit = menuButton.makeButton();
        exit.setOnMouseClicked(e -> Platform.exit());
    }

    public Scene MenuScene() {
        BorderPane borderPane = new BorderPane();
        VBox buttons = new VBox();
        buttons.getChildren().addAll(this.start,
                this.settings, this.exit);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        VBox logo = new VBox();
        ImageView imageView = new ImageView("pong.png");
        imageView.setScaleX(0.70);
        imageView.setScaleY(0.70);
        logo.getChildren().add(imageView);
        logo.setAlignment(Pos.CENTER);
        borderPane.setTop(logo);
        borderPane.setCenter(buttons);
        return new Scene(borderPane, 1024, 512);
    }
}
