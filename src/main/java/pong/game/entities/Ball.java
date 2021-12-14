package pong.game.entities;

import pong.controls.Settings;

import java.util.Random;

public class Ball extends Settings {

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
        this.xSpeed = difficulty * (new Random().nextInt(2) == 0 ? 1 : -1);
        this.ySpeed = -1 + new Random().nextInt(2) == 0 ? 1 : -1;
    }

    public boolean hitsTopOrBottom() {
        if (yPos > height || yPos < 0) {
            return true;
        }
        return false;
    }

    public void reverseYdirection() {
        this.ySpeed = ySpeed * -1;
    }

    public void hitsPlayer(int playeryPos) {
        if (yPos >= playeryPos && yPos <= playeryPos + playerHeight) {
            double relative = playeryPos + (playerHeight / 2) - yPos;
            double normal = relative / (playerHeight / 2) * 2;
            double bounceangle = normal * difficulty;
            this.ySpeed = (int) bounceangle;
            this.xSpeed *= -1;
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
