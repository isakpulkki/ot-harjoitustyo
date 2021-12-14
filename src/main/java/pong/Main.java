package pong;


import javafx.scene.text.Font;
import pong.controls.Settings;
/**
Launches the start-method's main, which starts the application, had a bug with only one main
 */
public class Main {


    public static void main(String[] args) {
        setSettings();
        Start.main(args);
    }

    /**
    Here you can adjust the games settings
     */

    public static void setSettings(){

        Settings.height = 720;
        Settings.width = 1280;
        Settings.style = "-fx-background-color: #808080";
        Settings.font = Font.font("Verdana", 40);
        Settings.playerHeight = 100;
        Settings.playerWidth = 20;
        Settings.difficulty = 3;
        Settings.ballRadius = 20;
        Settings.playerSpeed = 7;
    }
}