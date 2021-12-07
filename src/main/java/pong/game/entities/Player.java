package pong.game.entities;

import pong.controls.Settings;

public class Player extends Settings {
    private int score;
    private final int xPos;
    private int yPos;

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
