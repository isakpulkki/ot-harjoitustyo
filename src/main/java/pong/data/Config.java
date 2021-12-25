package pong.data;

import javafx.scene.text.Font;



public class Config {

    public static int height;
    public static int width;
    public static int playerHeight;
    public static int playerWidth;
    public static int ballRadius;
    public static int difficulty;
    public static int playerSpeed;
    public static String style;
    public static Font font;
    public static boolean sounds;
    public static Font smallFont;

    //Tästä voi säätää pelin teemaa ja kokoa universaalisti
    public Config() {
    }

    public int getHeight() {
        return height;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        Config.font = font;
    }
}
