package pong.controls;

import javafx.scene.text.Font;



public class Settings {

    public int height;
    public int width;
    public int playerHeight;
    public int playerWidth;
    public int ballRadius;
    public int playerSpeed;
    public String style;
    public Font font;

    //Tästä voi säätää pelin teemaa ja kokoa universaalisti
    public Settings() {
        this.height = 1000;
        this.width = 1200;
        this.style = "-fx-background-color: #808080";
        this.font = Font.font("Verdana", 40);
        this.playerHeight = 100;
        this.playerWidth = 20;
        this.ballRadius = 20;
        this.playerSpeed = 7;
    }


    public int getHeight() {
        return height;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }


}
