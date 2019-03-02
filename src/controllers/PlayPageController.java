package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Game;
import model.Player;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlayPageController extends Controller {

    @FXML public AnchorPane anchorPane, player_pane, play_pane;
    @FXML public Rectangle quitRectangle;
    @FXML public ImageView lane_imageView;
    @FXML public TabPane player_tabPane;
    @FXML public Text money_popup_text;
    @FXML public Button trade_button, end_turn_button;

    private List<Player> _players;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        _players = _game.getPlayers();

        for (Player player : _players) {
            Tab tab = new Tab();
            tab.setText(player.getFirstName());
        }
    }

    @Override
    protected void loadPane(String fileName) {

    }

}
