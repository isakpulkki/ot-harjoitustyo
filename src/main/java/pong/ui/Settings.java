package pong.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import pong.data.Config;
import pong.ui.controls.CustomButton;
import pong.data.ConfigDao;

import java.sql.SQLException;

/**
 * Makes the Settings -scene in the application
 */
public class Settings extends Config {

    Stage stage;

    public Settings(Stage stage) {
        this.stage = stage;

    }

    /*
    With this you can get the Settings scene
     */
    public Label labelMaker(String name) {
        Label label = new Label(name);
        label.setTextFill(Color.rgb(40, 40, 40));
        label.setFont(smallFont);
        return label;
    }

    public void getSettingsScene() {

        BorderPane borderPane = new BorderPane();
        borderPane.setFocusTraversable(true);
        borderPane.setStyle(style);
        CustomButton menuButton = new CustomButton("Päävalikko");
        Button menu = menuButton.makeButton();
        menu.setOnMouseClicked(e -> {
            this.stage.setScene(new Menu(stage).getMenuScene());
            stage.show();
        });

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll( labelMaker("Peliäänet"), soundsButton(), labelMaker("Vaikeustaso"), difficultySlider(),
                labelMaker("Pallo"), ballSizeSlider(), labelMaker("Pelaaja"), playerSizeSlider(), menu);
        borderPane.setCenter(vbox);
        this.stage.setScene(new Scene(borderPane, width, height));
    }
/*
Makes a slider for this scene
 */

    public Button soundsButton(){
        String text;
        if (Settings.sounds) {
            text = "Pois";
        } else {
            text = "Päälle";
        }
        CustomButton soundsButton = new CustomButton(text);
        Button sounds = soundsButton.makeButton();
        sounds.setOnMouseClicked(e -> {
            if (Settings.sounds) {
                Settings.sounds = false;
                try {
                    ConfigDao.updateValue("sounds", 0);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sounds.setText("Päälle");
            } else {
                Settings.sounds = true;
                sounds.setText("Pois");
                try {
                    ConfigDao.updateValue("sounds", 1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return sounds;
    }


    public Slider playerSizeSlider() {
        Slider slider = new Slider(75, 125, 1);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(width / 5);
        slider.setValue(playerHeight);

        slider.setShowTickLabels(true);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                if (aDouble == 75) {
                    return "Ohut";
                }
                if (aDouble == 100) {
                    return "Perus";
                }

                return "Leveä";
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });


        slider.setOnMouseReleased(e -> {
                    Settings.playerHeight = (int) slider.getValue();
            try {
                ConfigDao.updateValue("playerheight", (int) slider.getValue());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                }
        );
        slider.getStylesheets().add(getClass().getResource("/slider.css").toExternalForm());
        return slider;
    }

    public Slider ballSizeSlider() {
        Slider slider = new Slider(16, 24, 1);
        slider.setMajorTickUnit(4);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(width / 5);
        slider.setValue(ballRadius);
    slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                if (aDouble == 16) {
                    return "Pieni";
                }
                if (aDouble == 20) {
                    return "Normaali";
                }

                return "Suuri";
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        slider.setOnMouseReleased(e -> {
                    Settings.ballRadius = (int) slider.getValue();
            try {
                ConfigDao.updateValue("ballradius", (int) slider.getValue());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                }
        );
        slider.getStylesheets().add(getClass().getResource("/slider.css").toExternalForm());
        return slider;
    }

    public Slider difficultySlider() {
        Slider slider = new Slider(6, 14, 1);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(4);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        slider.setMaxWidth(width / 5);
        slider.setValue(difficulty);
        slider.setShowTickLabels(true);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                if (aDouble == 5) {
                    return "Helppo";
                }
                if (aDouble == 10) {
                    return "Keskitaso";
                }

                return "Vaikea";
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
        slider.setOnMouseReleased(e -> {
                    Settings.difficulty = (int) slider.getValue();
                    try {
                        ConfigDao.updateValue("difficulty", (int) slider.getValue());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        slider.getStylesheets().add(getClass().getResource("/slider.css").toExternalForm());
        return slider;
    }
}
