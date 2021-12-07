package pong.ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pong.controls.Settings;
import pong.controls.MenuButton;

public class MenuScene extends Settings {

    public Button exit;
    public Button gameSettings;
    public Button start;
    Stage stage;

    public MenuScene(Stage stage) {
        this.stage = stage;
        makeButtons();
    }


    public Scene getMenuScene() {
        BorderPane borderPane = new BorderPane();
        VBox buttons = new VBox();
        buttons.getChildren().addAll(this.start, this.gameSettings, this.exit);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        VBox logo = new VBox(10);
        ImageView imageView = new ImageView("pong.png");
        imageView.setScaleX(0.70);
        imageView.setScaleY(0.70);
        logo.getChildren().add(imageView);
        logo.setAlignment(Pos.CENTER);
        logo.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(logo);
        borderPane.setCenter(buttons);
        borderPane.setStyle(style);
        return new Scene(borderPane, width, height);
    }

    public void makeButtons() {
        MenuButton menuButton = new MenuButton("Pelaa");
        start = menuButton.makeButton();
        start.setOnMouseClicked(e -> new PongScene(stage).getPongScene());
        menuButton = new MenuButton("Asetukset");
        gameSettings = menuButton.makeButton();
        gameSettings.setOnMouseClicked(e -> new SettingsScene(stage).getSettingsScene());
        menuButton = new MenuButton("Poistu");
        exit = menuButton.makeButton();
        exit.setOnMouseClicked(e -> Platform.exit());
    }
}
