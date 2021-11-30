package pong.controls;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MenuButton {

    String text;
    Font font;
    Settings settings;

    public MenuButton(String text, Settings settings) {
        this.text = text;
        this.settings = settings;
        this.font = settings.getFont();
    }

    public Button makeButton() {
        Button button = new Button(this.text);
        button.setFont(font);
        button.setStyle("-fx-background-color: transparent");
        button.setTextFill(Color.WHITE);
        button.setOnMouseEntered((event -> {
            button.setEffect(new DropShadow());
        }));
        button.setOnMouseExited((event -> {
            button.setEffect(null);
        }));
        return button;
    }
}
