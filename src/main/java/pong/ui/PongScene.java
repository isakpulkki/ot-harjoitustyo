package pong.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class PongScene {

    public Scene getPongScene(){
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Text("Tänne tulee peli."));
        return new Scene(borderPane, 1024, 512);
    }
}
