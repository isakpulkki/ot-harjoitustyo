package pong.game.entities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.data.Config;

import java.util.Random;

public class Ball extends Config {

    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }


    public Ball() {
        this.xPos = width / 2;
        this.yPos = height / 2;
        int upOrDown;
        Random random = new Random();
        if (random.nextBoolean()) {
            upOrDown = -1;
        } else {
            upOrDown = 1;
        }
        this.ySpeed = (int) (difficulty * Math.sin(0.25));
        this.xSpeed = (int) (upOrDown * Math.sqrt(difficulty * difficulty - (ySpeed * ySpeed)));

    }

    public boolean hitsTopOrBottom() {
        if (yPos > height || yPos < 0) {
            return true;
        }
        return false;
    }

    public void reverseYdirection() {
        if (yPos < 0){
            yPos += Math.abs(ySpeed);
        }

        if (yPos > height) {
            yPos -= Math.abs(ySpeed);
        }
        this.ySpeed = ySpeed * -1;
    }

    public void hitsPlayer(int playeryPos) {
        if (yPos + ballRadius >= playeryPos && yPos <= playeryPos + playerHeight) {
            double relative = playeryPos + (playerHeight / 2) - yPos;
            double normal = relative / (playerHeight / 2);
            this.ySpeed = (int) (difficulty * -Math.sin(normal));
            this.xSpeed = xSpeed + 1;
            if (this.xPos < playeryPos) {
                this.xPos -= xSpeed;
                xSpeed -= 1;
            } else if (this.xPos > playeryPos) {
                this.xPos -= xSpeed;
                xSpeed += 1;
            }
            this.xSpeed *= -1;
            if (sounds) {
                MediaPlayer sound = new MediaPlayer(new Media(getClass().getResource("/hitsplayer.mp3").toExternalForm()));
                sound.play();
            }
        }
    }

    public int getxPos() {
        return xPos;
    }

    public void moveBall() {
        this.xPos += this.xSpeed;
        this.yPos += this.ySpeed;
    }

    public int getyPos() {
        return yPos;
    }
}
