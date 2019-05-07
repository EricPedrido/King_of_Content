package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Game;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerPaneController extends Controller {

    @FXML public Text name_text, money_text, fans_text;
    @FXML public ImageView avatar_image, card_image;
    @FXML public ProgressBar fans_progressBar;
    @FXML public ListView<String> purchased_list;
    @FXML public AnchorPane anchorPane;

    private Player _player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set player and place on back of queue
        _player = Game.getInstance().getPlayers().remove(0);
        Game.getInstance().getPlayers().add(_player);

        // Set Player attributes to be displayed
        anchorPane.setStyle("-fx-background-color: " + _player.getColorAsString());
        name_text.setText(_player.getName());
        avatar_image.setImage(_player.getAvatar().getImage());
        money_text.setText(Integer.toString(_player.getMoney()));
        updateFanProgress();

    }

    private void updateFanProgress() {
        int fans = _player.getFans();
        fans_text.setText(Integer.toString(fans) + "/1000000");
        fans_progressBar.setProgress((double) _player.getFans()/1000000);
    }
}
