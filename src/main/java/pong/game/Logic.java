package pong.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import pong.data.Config;
import pong.game.entities.Ball;
import pong.game.entities.Player;

public class Logic extends Config {


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
    public boolean gameinProgress;

    public boolean isGameinProgress() {
        return gameinProgress;
    }

    public void setGameinProgress(boolean gameinProgress) {
        this.gameinProgress = gameinProgress;
    }

    public Logic() {
        leftPlayer = new Player(8, height / 2 - (100 / 2));
        rightPlayer = new Player(width - playerWidth - 8, height / 2 - (100 / 2));
        this.gameStarted = false;

    }

    public void gameinProgress(){
        if (leftPlayer.getScore() > 0 || rightPlayer.getScore() > 0){
            gameinProgress = true;
            return;
        }
            gameinProgress = false;
    }

    public void getGameLogic() {

        checkMovement();
        gameinProgress();
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

    public void checkForScores() {
        if (this.ball.getxPos() < this.leftPlayer.getxPos() - playerWidth) {
            rightPlayer.increaseScore();
            if (rightPlayer.getScore() == 10){
                leftPlayer.setScore(0);
                rightPlayer.setScore(0);
                winnerRight = true;
            }
            gameStarted = false;
        }

        if (this.ball.getxPos() > this.rightPlayer.getxPos() + playerWidth) {

            leftPlayer.increaseScore();
            if (leftPlayer.getScore() == 10){
                leftPlayer.setScore(0);
                rightPlayer.setScore(0);
                winnerLeft = true;
            }
            gameStarted = false;
        }
    }

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
