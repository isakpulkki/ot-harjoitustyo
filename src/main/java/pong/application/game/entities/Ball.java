package pong.application.game.entities;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.data.Config;
import java.util.Random;

/**
 * Ball in the game
 */

public class Ball extends Config {

    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    public Ball() {
        this.xPos = width / 2;
        this.yPos = height / 2;
        setBallSpeed();
    }

    /**
     * Randomizes the ball's starting direction and sets their speed
     */
    public void setBallSpeed() {
        int upOrDown;
        int leftOrRight;
        Random random = new Random();
        if (random.nextBoolean()) {
            leftOrRight = -1;
        } else {
            leftOrRight = 1;
        }
        if (random.nextBoolean()) {
            upOrDown = -1;
        } else {
            upOrDown = 1;
        }
        this.ySpeed = (int) (upOrDown * difficulty * Math.sin(0.25));
        this.xSpeed = (int) (leftOrRight * Math.sqrt(difficulty * difficulty - (ySpeed * ySpeed)));
    }

    /**
     * Check if ball hits top or bottom
     */
    public boolean hitsTopOrBottom() {
        return yPos > height || yPos < 0;
    }

    /**
     * Reverses ball y-direction if it hits top or bottom
     */
    public void reverseYdirection() {
        if (yPos < 0) {
            yPos += Math.abs(ySpeed);
        }

        if (yPos > height) {
            yPos -= Math.abs(ySpeed);
        }
        this.ySpeed = ySpeed * -1;
    }

    /**
     * Checks if the ball hits the player, if yes then the method calculates its relative and normalized position in players
     * y-axis and uses math to calculates angle the ball should go next
     */
    public void hitsPlayer(int playeryPos) {
        if (yPos + ballRadius >= playeryPos && yPos <= playeryPos + playerHeight) {
            double relative = playeryPos + (playerHeight / 2) - yPos;
            double normal = relative / (playerHeight / 2);
            this.ySpeed = (int) (difficulty * -Math.sin(normal));
            checkIfBallTooFar(playeryPos);
            this.xSpeed = xSpeed + 1;
            this.xSpeed *= -1;
            if (sounds) {
                MediaPlayer sound = new MediaPlayer(new Media(getClass().getResource("/hitsplayer.mp3").toExternalForm()));
                sound.play();
            }
        }
    }

    /**
     * Checks if the ball goes too far in to the paddle, where it would start looping inside the paddle
     */
    public void checkIfBallTooFar(int playeryPos) {
        if (this.xPos < playeryPos) {
            this.xPos -= xSpeed;
            xSpeed -= 1;
        } else if (this.xPos > playeryPos) {
            this.xPos -= xSpeed;
            xSpeed += 1;
        }
    }

    /**
     * Moves the ball in the direction it is going
     */
    public void moveBall() {
        this.xPos += this.xSpeed;
        this.yPos += this.ySpeed;
    }


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }
}
