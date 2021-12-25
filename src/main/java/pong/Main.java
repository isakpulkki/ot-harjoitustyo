package pong;


import javafx.scene.text.Font;
import pong.data.Config;
import pong.data.ConfigDao;

/**
 * Launches the start-method's main, which starts the application, had a bug with only one main
 */
public class Main {


    public static void main(String[] args) {
        setSettings();
        Start.main(args);
    }

    /**
     * Here you can adjust the games settings
     */

    public static void setSettings() {
        Config.height = 750;
        Config.width = 1500;
        Config.style = "-fx-background-color: #808080";
        Config.playerWidth = 5;
        Config.playerSpeed = 12;
        Config.font = Font.font("Arial", 35);
        Config.smallFont = Font.font("Arial", 30);
        ConfigDao.makeConnection();
    }
}