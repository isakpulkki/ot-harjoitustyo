package pong.ui.controls;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import pong.data.Config;

public class CustomButton extends Config {

    String text;

    public CustomButton(String text) {
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
