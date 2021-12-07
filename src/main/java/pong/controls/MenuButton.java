package pong.controls;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class MenuButton extends Settings {

    String text;

    public MenuButton(String text) {
        this.text = text;
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
