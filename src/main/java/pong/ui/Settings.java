package pong.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pong.controls.MenuButton;

/**
 * Makes the Settings -scene in the application
 */
public class Settings extends pong.controls.Settings {

    Stage stage;

    public Settings(Stage stage) {
        this.stage = stage;

    }

/*
With this you can get the Settings scene
 */

    public void getSettingsScene() {

        BorderPane borderPane = new BorderPane();
        borderPane.setFocusTraversable(true);
        Label label = new Label("Valitse vaikeustaso");
        label.setFont(font);
        borderPane.setStyle(style);
        Slider slider = sliderMaker();
        slider.setValue(difficulty);
        slider.setOnMouseReleased(e -> {
                    Settings.difficulty = (int) slider.getValue();
                }
        );
        MenuButton menuButton = new MenuButton("Päävalikko");
        Button menu = menuButton.makeButton();
        menu.setOnMouseClicked(e -> {
            this.stage.setScene(new Menu(stage).getMenuScene());
            stage.show();
        });
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, slider, menu);
        borderPane.setCenter(vbox);
        this.stage.setScene(new Scene(borderPane, width, height));
    }
/*
Makes a slider for this scene
 */

    public Slider sliderMaker() {
        Slider slider = new Slider(1, 9, 1);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(4);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(width / 3);
        return slider;
    }
}
