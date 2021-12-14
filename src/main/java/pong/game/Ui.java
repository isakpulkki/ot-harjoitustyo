package pong.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import pong.controls.Settings;
import pong.game.entities.Ball;
import pong.game.entities.Player;

import java.io.FileNotFoundException;

/**
 * This class makes the user interface and calls for logic
 */

public class Ui extends Settings {

    GraphicsContext graphicsContext;
    Logic logic;

    public Ui(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        logic = new Logic();
    }

    /**
     * This method initializes the game graphicsContext, and makes Logic-object
     * @throws FileNotFoundException throws this if the file is not found
     */

    public void getGraphics() throws FileNotFoundException {
        graphicsContext.clearRect(0, 0, width, height);
        logic.getGameLogic();
        Player leftPlayer = logic.getLeftPlayer();
        Player rightPlayer = logic.getRightPlayer();
        Ball ball = logic.getBall();
        graphicsContext.setFont(font);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.fillRect(leftPlayer.getxPos(), leftPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.fillRect(rightPlayer.getxPos(), rightPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setFill(Color.BLACK);
        String score = leftPlayer.getScore() + " - " + rightPlayer.getScore();
        graphicsContext.fillText(score, (width / 2), 50);
        if (logic.isGameStarted()) {
            graphicsContext.fillOval(ball.getxPos(), ball.getyPos(), ballRadius, ballRadius);
        } else {
            pauseGame(graphicsContext);
        }
    }

    /**
     * This function pauses the game
     * @param graphicsContext, includes the games graphics
     */

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



    /**
     * Just returns this Ui's Logic-object
     * @return
     */
    public Logic getGameLogic() {
        return logic;
    }

}
