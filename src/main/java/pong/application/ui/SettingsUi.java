package pong.application.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pong.application.settings.SettingsLogic;
import pong.data.Config;
import pong.utils.CustomButton;

/**
 * Creates Settings -scene for the application
 */
public class SettingsUi extends Config {

    Stage stage;

    public SettingsUi(Stage stage) {
        this.stage = stage;
    }

    /**
     * Creates and shows the SettingsScene in the stage
     */
    public void getSettingsScene() {
        BorderPane borderPane = new BorderPane();
        borderPane.setFocusTraversable(true);
        borderPane.setStyle(style);
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        SettingsLogic logic = new SettingsLogic();
        vbox.getChildren().addAll(customLabel("Vaikeustaso"), logic.difficultySlider(), customLabel("Pallo"), logic.ballSizeSlider(), customLabel("Pelaaja"), logic.playerSizeSlider(), menuButton());
        borderPane.setCenter(vbox);
        this.stage.setScene(new Scene(borderPane, width, height));
    }

    /**
     * Creates labels for different settings
     */
    public Label customLabel(String name) {
        Label label = new Label(name);
        label.setTextFill(Color.rgb(40, 40, 40));
        label.setFont(smallFont);
        return label;
    }

    /**
     * Creates button to go back to the menu
     */
    public Button menuButton() {
        Button menuButton = new CustomButton("Päävalikko").getCustomButton();
        menuButton.setOnMouseClicked(e -> {
            new MenuUi(stage).getMenuScene();
            stage.show();
        });
        return menuButton;
    }

}
