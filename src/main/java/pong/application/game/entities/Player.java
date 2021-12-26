package pong.application.game.entities;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.data.Config;

/**
 * Player in the game
 */
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

    /**
     * increase players score
     */
    public void increaseScore() {
        if (sounds) {
            MediaPlayer sound = new MediaPlayer(new Media(getClass().getResource("/score.mp3").toExternalForm()));
            sound.play();
        }
        this.score++;
    }

    /**
     * Increase y-axis
     */
    public void increaseY() {
        if ((this.yPos + playerHeight) > height) {
            this.yPos = height - playerHeight;
        }
        this.yPos += playerSpeed;
    }

    /**
     * Decrease y-axis
     */
    public void decreaseY() {

        if (this.yPos < 0) {
            this.yPos = 0;
        }
        this.yPos -= playerSpeed;
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
}
