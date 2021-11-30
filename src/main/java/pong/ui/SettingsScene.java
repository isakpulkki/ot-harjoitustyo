package pong.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pong.controls.Settings;
import pong.controls.MenuButton;

public class SettingsScene {
    Stage stage;
    Settings settings;
    public int height;
    public int width;
    public String style;
    public Font font;

    public SettingsScene(Stage stage, Settings settings) {

        this.stage = stage;
        this.settings = settings;
        height = settings.getHeight();
        width = settings.getWidth();
        style = settings.getStyle();
        font = settings.getFont();

    }

    public void getSettingsScene() {
        BorderPane borderPane = new BorderPane();
        borderPane.setFocusTraversable(true);
        borderPane.setCenter(new Text("Tänne tulee asetukset."));
        borderPane.setStyle(style);
        MenuButton menuButton = new MenuButton("Päävalikko", settings);
        Button menu = menuButton.makeButton();
        menu.setOnMouseClicked(e -> {
            this.stage.setScene(new MenuScene(stage, settings).getMenuScene());
            stage.show();
        });
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(menu);
        borderPane.setCenter(vbox);
        this.stage.setScene(new Scene(borderPane, width, height));
    }
}
