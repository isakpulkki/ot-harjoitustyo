
import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.ui.MenuButton;


import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class MenuButtonTest {

    public Button button;

    public MenuButtonTest(){
        this.button = new Button();
    }
    @Before
    public void MenuButton() {
        MenuButton menuButton = new MenuButton("Testi");
        button = menuButton.makeButton();

    }

    @Test
    public void ButtonTextTest() {
        assertEquals(button.getText(), "Testi");
    }

    @Test
    public void FontTest() {
        assertEquals(button.getFont(), Font.font("Verdana", 23));
    }

}
