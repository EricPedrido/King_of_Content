package controllers.play_pane_controllers;

import controllers.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Game;

import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;

public class RollController extends Controller {
    public AnchorPane play_pane;
    public Button roll_button;
    public Text dice1_text, dice2_text, roll_value_text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roll_button.setOnAction(event -> roll());
    }

    private void roll() {
        Queue<Integer> roll = Game.getInstance().roll();

        dice1_text.setText(roll.poll() + "");
        dice2_text.setText(roll.poll() + "");
        roll_value_text.setText(roll.poll() + "");

        roll_button.setDisable(true);
    }
}
