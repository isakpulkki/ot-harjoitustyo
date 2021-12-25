import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.ui.controls.CustomButton;
import pong.data.Config;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class PreferencesTest {
    Config preferences;

    public PreferencesTest() {
        preferences = new Config();
    }


    @Test
    public void changeHeight() {
        Config.height = 2000;
        this.preferences.setFont(Font.font("Times New Roman", 20));
        assertEquals(2000, preferences.getHeight());
    }

    @Test
    public void changeFont() {
        Font font = Font.font("Times New Roman", 20);
        this.preferences.setFont(font);
        assertEquals(font, preferences.getFont());
    }

    @Test
    public void changeFontAndButtonChangesToo() {
        CustomButton menuButton = new CustomButton("Testi");
        Button testi = menuButton.makeButton();
        assertEquals(testi.getFont(), preferences.getFont());
    }
}
