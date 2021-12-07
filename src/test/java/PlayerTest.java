import de.saxsys.javafx.test.JfxRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.game.entities.Player;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class PlayerTest {
    Player player = new Player(100, 200);

    @Test
    public void increaseY(){
        this.player.increaseY();
        assertEquals(this.player.getyPos(), 200 + player.playerSpeed);
    }

    @Test
    public void decreaseY(){
        this.player.decreaseY();
        assertEquals(this.player.getyPos(), 200 - player.playerSpeed);
    }

}
