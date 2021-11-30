package pong.controls;

import javafx.scene.text.Font;



public class Settings {

    public int height;
    public int width;
    public String style;
    public Font font;

    //Tästä voi säätää pelin teemaa ja kokoa universaalisti
    public Settings() {
        this.height = 800;
        this.width = 1400;
        this.style = "-fx-background-color: #808080";
        this.font = Font.font("Verdana", 40);
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }


}
