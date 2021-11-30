package pong.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import pong.controls.Settings;

public class GameLogic {

    private final int width;
    private final int height;
    private final int playerheight;
    private final int playerwidth;
    private final int leftscore;
    private final int rightscore;
    private final int leftXpos;
    private final int leftYpos;
    private final int rightXpos;
    private final int rightYpos;
    Settings settings;
    Font font;

    public GameLogic(int height, int width, Settings settings) {
        this.height = height;
        this.width = width;
        this.settings = settings;
        this.font = settings.getFont();

        //Tästä voi säätää pelaajan kokoa
        this.playerheight = 100;
        this.playerwidth = 20;

        this.leftscore = 0;
        this.rightscore = 0;

        this.leftXpos = 1;
        this.leftYpos = height / 2 - (playerheight / 2);
        this.rightXpos = width - playerwidth - 1;
        this.rightYpos = height / 2 - (playerheight / 2);
    }

    public void getGraphics(GraphicsContext graphicsContext) {

        graphicsContext.setFont(font);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.setLineWidth(2);
        graphicsContext.fillRect(leftXpos, leftYpos, playerwidth, playerheight);
        graphicsContext.fillRect(rightXpos, rightYpos, playerwidth, playerheight);
        graphicsContext.setFill(Color.BLACK);
        String score = leftscore + " - " + rightscore;
        graphicsContext.fillText(score, (width / 2), 50);
        String menu = "Päävalikko [ESC]";
        graphicsContext.fillText(menu, (width / 2), height - 25);
    }
}
