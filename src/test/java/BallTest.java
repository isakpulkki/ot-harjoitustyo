import de.saxsys.javafx.test.JfxRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.application.game.entities.Ball;
import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class BallTest {
    Ball ball = new Ball();

@Test
    public void movingBallmovesBall(){
        int x = this.ball.getxPos() + this.ball.getxSpeed();
        int y = this.ball.getyPos() + this.ball.getySpeed();
        this.ball.moveBall();
        assertEquals(this.ball.getxPos(), x);
        assertEquals(this.ball.getyPos(), y);
    }

}
