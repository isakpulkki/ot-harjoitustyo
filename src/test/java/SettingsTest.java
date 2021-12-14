import de.saxsys.javafx.test.JfxRunner;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.junit.Test;
import org.junit.runner.RunWith;
import pong.controls.MenuButton;
import pong.controls.Settings;

import static org.junit.Assert.assertEquals;

@RunWith(JfxRunner.class)
public class SettingsTest {
    Settings settings;

    public SettingsTest() {
        settings = new Settings();
    }


    @Test
    public void changeHeight() {
        Settings.height = 2000;
        this.settings.setFont(Font.font("Times New Roman", 20));
        assertEquals(2000, settings.getHeight());
    }

    @Test
    public void changeFont() {
        Font font = Font.font("Times New Roman", 20);
        this.settings.setFont(font);
        assertEquals(font, settings.getFont());
    }

    @Test
    public void changeFontAndButtonChangesToo() {
        MenuButton menuButton = new MenuButton("Testi");
        Button testi = menuButton.makeButton();
        assertEquals(testi.getFont(), settings.getFont());
    }
}
