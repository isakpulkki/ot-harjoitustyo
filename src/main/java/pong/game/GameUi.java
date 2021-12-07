package pong.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import pong.controls.Settings;
import pong.game.entities.Ball;
import pong.game.entities.Player;

import java.io.FileNotFoundException;

public class GameUi extends Settings {

    GraphicsContext graphicsContext;
    GameLogic gameLogic;

    public GameUi(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        gameLogic = new GameLogic();
    }

    public void getGraphics() throws FileNotFoundException {
        graphicsContext.clearRect(0, 0, width, height);
        gameLogic.getGameLogic();
        Player leftPlayer = gameLogic.getLeftPlayer();
        Player rightPlayer = gameLogic.getRightPlayer();
        Ball ball = gameLogic.getBall();
        graphicsContext.setFont(font);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.fillRect(leftPlayer.getxPos(), leftPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.fillRect(rightPlayer.getxPos(), rightPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setFill(Color.BLACK);
        String score = leftPlayer.getScore() + " - " + rightPlayer.getScore();
        graphicsContext.fillText(score, (width / 2), 50);
        if (gameLogic.isGameStarted()) {
            graphicsContext.fillOval(ball.getxPos(), ball.getyPos(), ballRadius, ballRadius);
        } else {
            pauseGame(graphicsContext);
        }
    }

    public void pauseGame(GraphicsContext graphicsContext) {
        graphicsContext.fillText("Aloita painamalla näppäintä", width / 2, height / 2);
        Image image = new Image("/up.png", 100, 100, false, false);
        graphicsContext.drawImage(image, width - image.getWidth() * 2, height / 2 - (image.getHeight() / 1.5));
        image = new Image("/down.png", 100, 100, false, false);
        graphicsContext.drawImage(image, width - image.getWidth() * 2, height / 2 + (image.getHeight() / 1.5));
        image = new Image("/w.png", 100, 100, false, false);
        graphicsContext.drawImage(image, image.getWidth(), height / 2 - image.getHeight() / 1.5);
        image = new Image("/s.png", 100, 100, false, false);
        graphicsContext.drawImage(image, image.getWidth(), height / 2 + image.getHeight() / 1.5);
        image = new Image("/esc.png", 100, 100, false, false);
        graphicsContext.drawImage(image, width / 2 - (image.getWidth() / 2), (height - image.getHeight() * 1.2));
        graphicsContext.fillText("Päävalikko", width / 2, height - (image.getHeight() * 1.5));
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

}
