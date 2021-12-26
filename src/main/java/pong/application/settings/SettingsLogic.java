package pong.application.settings;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import pong.application.ui.SettingsUi;
import pong.data.Config;
import pong.data.ConfigDao;
import pong.utils.CustomButton;
import pong.utils.CustomSlider;

/**
 * This class has the logic behind changing settings
 */
public class SettingsLogic extends Config {

    /**
     * Creates slider to control the player-size
     */
    public Slider playerSizeSlider() {
        Slider slider = new CustomSlider(75, 125, 25).getCustomSlider();
        slider.setValue(playerHeight);
        slider.setLabelFormatter(customSliderLabels("Ohut", "Normaali", "Leveä", slider));
        slider.setOnMouseReleased(e -> {
            ConfigDao.updateValue("playerHeight", (int) slider.getValue());
        });
        return slider;
    }

    /**
     * Creates slider to control the ball-size
     */
    public Slider ballSizeSlider() {
        Slider slider = new CustomSlider(16, 24, 4).getCustomSlider();
        slider.setValue(ballRadius);
        slider.setLabelFormatter(customSliderLabels("Pieni", "Perus", "Iso", slider));
        slider.setOnMouseReleased(e -> {
            ConfigDao.updateValue("ballRadius", (int) slider.getValue());
        });
        return slider;
    }

    /**
     * Creates slider to control the ball's speed
     */

    public Slider difficultySlider() {
        Slider slider = new CustomSlider(6, 14, 4).getCustomSlider();
        slider.setValue(difficulty);
        slider.setLabelFormatter(customSliderLabels("Helppo", "Keskitaso", "Vaikea", slider));
        slider.setOnMouseReleased(e -> {
            ConfigDao.updateValue("difficulty", (int) slider.getValue());
        });
        return slider;
    }

    /**
     * Converts JavaFX values from sliders to something more user-friendly
     */
    public StringConverter<Double> customSliderLabels(String a, String b, String c, Slider slider) {
        return new StringConverter<Double>() {
            @Override
            public String toString(Double x) {
                if (x == slider.getMin()) {
                    return a;
                }
                if (x < slider.getMax()) {
                    return b;
                }
                return c;
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        };
    }
}
