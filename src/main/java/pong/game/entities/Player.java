package pong.game.entities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.data.Config;

public class Player extends Config {
    private int score;
    private final int xPos;
    private int yPos;

    public void setScore(int score) {
        this.score = score;
    }

    public Player(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.score = 0;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }


    public int getScore() {
        return this.score;
    }

    public void increaseScore() {
        if (sounds) {
            MediaPlayer sound = new MediaPlayer(new Media(getClass().getResource("/score.mp3").toExternalForm()));
            sound.play();
        }
        this.score++;
    }

    public void increaseY() {
        if ((this.yPos + playerHeight) > height) {
            this.yPos = height - playerHeight;
        }
        this.yPos += playerSpeed;
    }

    public void decreaseY() {

        if (this.yPos < 0) {
            this.yPos = 0;
        }
        this.yPos -= playerSpeed;
    }
}
