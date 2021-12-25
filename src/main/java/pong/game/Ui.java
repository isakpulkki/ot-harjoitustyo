package pong.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import pong.data.Config;
import pong.game.entities.Ball;
import pong.game.entities.Player;

import java.io.FileNotFoundException;

/**
 * This class makes the user interface and calls for logic
 */

public class Ui extends Config {

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
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(leftPlayer.getxPos(), leftPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(rightPlayer.getxPos(), rightPlayer.getyPos(), playerWidth, playerHeight);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.setStroke(Color.WHITE);
        graphicsContext.setLineWidth(5);
        graphicsContext.setLineDashes(20);
        graphicsContext.strokeLine((width / 2), 0, width / 2, height);

        graphicsContext.setFill(Color.BLACK);
        String score = leftPlayer.getScore() + " - " + rightPlayer.getScore();

        graphicsContext.fillText(score, (width / 2), 40);
        if (logic.isGameStarted()) {
            if (logic.isWinnerLeft() || logic.isWinnerRight()){
                logic.setWinnerLeft(false);
                logic.setWinnerRight(false);
            }
            graphicsContext.fillOval(ball.getxPos(), ball.getyPos(), ballRadius, ballRadius);
        }
        else {
            if (logic.gameinProgress){
                pauseGameinProgress(graphicsContext);
            }
            else {
                pauseGame(graphicsContext);
            }
        }
    }

    /**
     * This function pauses the game
     * @param graphicsContext, includes the games graphics
     */


    public void pauseGameinProgress(GraphicsContext graphicsContext){
        graphicsContext.fillText("Jatka painamalla näppäintä", width / 2, height / 2);

        Image image;
        if (logic.isWinnerLeft()){
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillText("Voittaja!", width / 3, (height / 4) + 55);
            image = new Image("/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, (width / 5), (height / 4));


        }
        if (logic.isWinnerRight()){
            graphicsContext.setFill(Color.BLUE);
            graphicsContext.fillText("Voittaja!", width - (width/5), (height / 4) + 55);
            image = new Image("/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, width - (width/3), (height / 4));
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
        if (logic.isWinnerLeft()){
            graphicsContext.setFill(Color.RED);
            graphicsContext.fillText("Voittaja!", width / 3, (height / 4) + 55);
            image = new Image("/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, (width / 5), (height / 4));


        }
        if (logic.isWinnerRight()){
            graphicsContext.setFill(Color.BLUE);
            graphicsContext.fillText("Voittaja!", width - (width/5), (height / 4) + 55);
            image = new Image("/trophy.png", 100, 100, false, false);
            graphicsContext.drawImage(image, width - (width/3), (height / 4));
        }
    }



    /**
     * Just returns this Ui's Logic-object
     * @return
     */
    public Logic getGameLogic() {
        return logic;
    }

}
