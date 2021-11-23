package pong.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class SettingsScene {
    public Scene getSettingsScene(){
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Text("Tänne tulee asetukset."));
        return new Scene(borderPane, 1024, 512);
    }
}
