package controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Board;
import model.Game;
import model.Player;
import model.tiles.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;

public class PlayPageController extends PageController {

    @FXML
    public AnchorPane anchorPane, play_pane;
    @FXML
    public Rectangle quitRectangle;
    @FXML
    public ImageView lane_imageView;
    @FXML
    public TabPane player_tabPane;
    @FXML
    public Text money_popup_text, loading_text;
    @FXML
    public Button trade_button, end_turn_button;
    @FXML
    public ProgressIndicator loading_progress;
    @FXML
    public BorderPane main_border_pane, lane_border_pane;

    private static PlayPageController INSTANCE;

    private Game _game;
    private List<Player> _players;
    //TODO KEEP TRACK OF WHOS TURN IT IS, AND DISABLE OTHER PLAYER TABS

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        INSTANCE = this;
        _game = Game.getInstance();
        _players = new ArrayList<>(_game.getPlayers());

        loadPane("/play_roll.fxml");

        for (Player player : _players) {
            player.setStartingPosition();
            anchorPane.getChildren().add(player.getAvatar());
        }

        setupPlayers();
    }

    /**
     * Initialise the tab and tab contents for each player.
     * Each player's tab contains an anchorPane which loads <q>player_pane.fxml</q> into it.
     * A loading screen appears until all players' tabs have successfully loaded.
     */
    private void setupPlayers() {
        setLoading(true);

        List<Tab> tabs = new ArrayList<>();

        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                for (Player player : _players) {

                    Tab tab = new Tab();

                    tab.setText(player.getFirstName());
                    tab.getStyleClass().add("base");
                    tab.setStyle("-fx-base: " + player.getColorAsString());

                    AnchorPane tabContent = new AnchorPane();
                    tabContent.setPrefSize(386, 460);
                    loadPane("/player_pane.fxml", tabContent);

                    tab.setContent(tabContent);
                    tabs.add(tab);
                }
                return null;
            }
        };
        task.setOnSucceeded(event -> {
            player_tabPane.getTabs().addAll(tabs);
            setLoading(false);
        });
        Thread thread = new Thread(task);
        thread.start();

    }

    /**
     * Show the loading animation and text while processes are being run in the background
     *
     * @param load true if loading screen is shown, otherwise false.
     */
    private void setLoading(boolean load) {
        loading_progress.setVisible(load);
        loading_text.setVisible(load);
        setQuitBoxOpacity(load);
    }

    @Override
    public void setQuitBoxOpacity(boolean visible) { // TODO Instead of a quit rectangle, replace with anchorpane disable
        quitRectangle.setVisible(visible);

        // Disable buttons in the background of the quit popup to restrict activity to the quit window
        trade_button.setDisable(visible);
        end_turn_button.setDisable(visible);
    }

    public void loadPane(Pane pane) {
        Platform.runLater(() -> loadPane(pane.toString()));
    }

    @Override
    protected void loadPane(String fileName) {
        super.loadPane(fileName, play_pane);
    }

    @Override
    protected void loadPane(String fileName, AnchorPane tabContent) {
        super.loadPane(fileName, tabContent);
    }

    public static PlayPageController getInstance() {
        return INSTANCE;
    }
}
