package pong.ui;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;


public class MenuButton {

    String text;

    public MenuButton(String text){
        this.text = text;
    }

    public Button makeButton(){
        Button button = new Button(this.text);
        button.setFont(Font.font("Verdana", 23));
        button.setStyle("-fx-background-color: transparent");
        button.setOnMouseEntered((event -> {
            button.setEffect(new DropShadow());
        }));
        button.setOnMouseExited((event -> {
            button.setEffect(null);
        }));
        return button;
    }
}
