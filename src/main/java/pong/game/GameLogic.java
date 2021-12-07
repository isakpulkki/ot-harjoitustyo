package pong.game;

import pong.controls.Settings;
import pong.game.entities.Ball;
import pong.game.entities.Player;

public class GameLogic extends Settings {


    private boolean gameStarted;
    private final Player leftPlayer;
    private final Player rightPlayer;
    private Ball ball;
    private boolean wPressed;
    private boolean sPressed;
    private boolean upPressed;
    private boolean downPressed;

    public GameLogic() {
        leftPlayer = new Player(5, height / 2 - (100 / 2));
        rightPlayer = new Player(width - 20 - 5, height / 2 - (100 / 2));
        this.gameStarted = false;
    }


    public void getGameLogic() {
        checkMovement();
        if (gameStarted) {
            ball.moveBall();
        } else {
            this.ball = new Ball();
        }
        if (this.ball.hitsTopOrBottom()) {
            this.ball.reverseYdirection();
        }
        checkForScores();
        checkForHits();
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

    public void checkForScores() {
        if (this.ball.getxPos() < this.leftPlayer.getxPos() - playerWidth) {
            leftPlayer.increaseScore();
            gameStarted = false;
        }
        if (this.ball.getxPos() > this.rightPlayer.getxPos() + playerWidth) {
            rightPlayer.increaseScore();
            gameStarted = false;
        }
    }

    public void checkForHits() {
        boolean inLeftPlayersX = this.ball.getxPos() < this.leftPlayer.getxPos() + playerWidth;
        boolean inRightPlayersX = this.ball.getxPos() + ballRadius > this.rightPlayer.getxPos();

        if (this.ball.hitsPlayer(inLeftPlayersX, this.leftPlayer.getyPos(), playerHeight)) {
            this.ball.reverseDirection();
        }
        if (this.ball.hitsPlayer(inRightPlayersX, this.rightPlayer.getyPos(), playerHeight)) {
            this.ball.reverseDirection();
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
