package pong.application.game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.application.game.entities.Ball;
import pong.application.game.entities.Player;
import pong.data.Config;

/**
 * Contains the games logic
 */
public class GameLogic extends Config {

    private boolean gameStarted;
    private final Player leftPlayer;
    private final Player rightPlayer;
    private Ball ball;
    private boolean wPressed;
    private boolean sPressed;
    private boolean upPressed;
    private boolean downPressed;
    private boolean winnerLeft;
    private boolean winnerRight;
    public boolean gameInProgress;

    public GameLogic() {
        leftPlayer = new Player(8, height / 2 - (100 / 2));
        rightPlayer = new Player(width - playerWidth - 8, height / 2 - (100 / 2));
        this.gameStarted = false;

    }

    /**
     * Controls the game logic
     */
    public void getGameLogic() {

        checkMovement();
        checkIfGameInProgress();
        if (gameStarted) {
            ball.moveBall();
        } else {
            this.ball = new Ball();
        }
        if (this.ball.hitsTopOrBottom()) {
            if (sounds) {
                MediaPlayer sound = new MediaPlayer(new Media(getClass().getResource("/toporbottom.mp3").toExternalForm()));
                sound.play();
            }
            this.ball.reverseYdirection();
        }
        checkForHits();
        checkForScores();
    }

    /**
     * Checks if the game is in progress or just starting
     */
    public void checkIfGameInProgress() {
        if (leftPlayer.getScore() > 0 || rightPlayer.getScore() > 0) {
            gameInProgress = true;
            return;
        }
        gameInProgress = false;
    }

    /**
     * Checks if players are moving currently or not and moves them if yes
     */
    public void checkMovement() {
        if (wPressed) {
            this.leftPlayer.decreaseY();
        }
        if (sPressed) {
            this.leftPlayer.increaseY();
        }
        if (downPressed) {
            this.rightPlayer.increaseY();
        }
        if (upPressed) {
            this.rightPlayer.decreaseY();
        }
    }

    /**
     * Resets players scores
     */
    public void resetPlayersScore() {
        leftPlayer.setScore(0);
        rightPlayer.setScore(0);
    }

    /**
     * Checks if player has scored
     */
    public void checkForScores() {
        if (this.ball.getxPos() < this.leftPlayer.getxPos() - playerWidth) {
            rightPlayer.increaseScore();
            if (rightPlayer.getScore() == winScore) {
                resetPlayersScore();
                winnerRight = true;
            }
            gameStarted = false;
        }
        if (this.ball.getxPos() > this.rightPlayer.getxPos() + playerWidth) {
            leftPlayer.increaseScore();
            if (leftPlayer.getScore() == winScore) {
                resetPlayersScore();
                winnerLeft = true;
            }
            gameStarted = false;
        }
    }

    /**
     * Checks if player has hit the ball
     */
    public void checkForHits() {

        if (this.ball.getxPos() <= this.leftPlayer.getxPos() + playerWidth) {
            this.ball.hitsPlayer(this.leftPlayer.getyPos());

        }
        if (this.ball.getxPos() + ballRadius >= this.rightPlayer.getxPos()) {
            this.ball.hitsPlayer(this.rightPlayer.getyPos());
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isWinnerLeft() {
        return winnerLeft;
    }

    public boolean isWinnerRight() {
        return winnerRight;
    }

    public void setWinnerLeft(boolean winnerLeft) {
        this.winnerLeft = winnerLeft;
    }

    public void setWinnerRight(boolean winnerRight) {
        this.winnerRight = winnerRight;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    public Player getRightPlayer() {
        return rightPlayer;
    }

    public Ball getBall() {
        return ball;
    }


    public void setwPressed(boolean wPressed) {
        this.wPressed = wPressed;
    }


    public void setsPressed(boolean sPressed) {
        this.sPressed = sPressed;
    }


    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }


    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
}
