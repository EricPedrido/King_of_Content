package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.AvatarListCell;
import model.Player;
import model.PlayerListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controls front_page.fxml
 *
 * @author Eric Pedrido
 */
public class FrontPageController extends Controller {
    @FXML public Button addButton, playButton, quitButton;
    @FXML public TextField nameTextField;
    @FXML public ComboBox<String> avatarComboBox;
    @FXML public ListView<PlayerListCell> namesListView;
    @FXML public ListView<ImageView> avatarListView;
    @FXML public AnchorPane anchorPane;

    private static FrontPageController INSTANCE;

    private List<Player> _players;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        INSTANCE = this;
        _players = new ArrayList<>();

        // Set-up empty observable lists
        ObservableList<PlayerListCell> emptyPlayers = FXCollections.observableArrayList();
        ObservableList<ImageView> emptyAvatars = FXCollections.observableArrayList();
        namesListView.setItems(emptyPlayers);
        avatarListView.setItems(emptyAvatars);

        populateComboBox();

        // set listeners and on-action events
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> addButton.setDisable(newValue.isEmpty()));
        addButton.setOnAction(event -> onAddClicked());
        quitButton.setOnAction(event -> onQuitClicked());
        playButton.setOnAction(event -> onPlayClicked());
    }

    /**
     * Takes the entered name and selected avatar, and adds it to the list
     * of players.
     *
     * There can be a maximum of 4 players at a time and avatars must be unique.
     * After 4 players are added to the list, users are restricted from adding any more.
     *
     * Also clears {@link #nameTextField} for ease of use.
     */
    private void onAddClicked() {
        // Setup the image of the avatar
        String name = nameTextField.getText();
        String avatar = avatarComboBox.getSelectionModel().getSelectedItem();

        ImageView image = new ImageView(new Image(avatar));
        image.setPreserveRatio(true);
        image.setFitHeight(35);
        image.setFitWidth(50);
        image.setId(avatar);

        Player player = new Player(name, image);
        _players.add(player);

        // Add name and avatar to their respective lists
        namesListView.getItems().add(new PlayerListCell(player));
        avatarListView.getItems().add(image);

        // Restrict users from exceeding maximum player count
        if (namesListView.getItems().size() == 4) {
            nameTextField.setPromptText("Max Players Reached");
            nameTextField.setDisable(true);
            avatarComboBox.setDisable(true);
        }

        nameTextField.setText("");
        addButton.setDisable(true);
        playButton.setDisable(false);
        // Ensure each avatar is unique
        avatarComboBox.getItems().remove(avatar);
        avatarComboBox.getSelectionModel().selectFirst();
    }

    private void onQuitClicked() {
        quit();
        setQuitBoxOpacity(false);
    }

    private void onPlayClicked() {
        this.loadPane("/play_page.fxml");
    }

    @Override
    public void setQuitBoxOpacity(boolean transparent) {
        super.setQuitBoxOpacity(transparent);
        setElementsDisable(!transparent);
    }

    private void setElementsDisable(boolean disable) {
        addButton.setDisable(disable);
        nameTextField.setDisable(disable);
        avatarComboBox.setDisable(disable);
        avatarListView.setDisable(disable);
        namesListView.setDisable(disable);
        playButton.setDisable(disable);
        quitButton.setDisable(disable);
    }

    public void onEditClicked(Player player, PlayerListCell cell) {
        removePlayer(player, cell);

        nameTextField.setText(player.getName());
        avatarComboBox.getSelectionModel().select(player.getAvatar().getId());
    }

    public void removePlayer(Player player, PlayerListCell cell) {
        _players.remove(player);

        namesListView.getItems().remove(cell);
        avatarListView.getItems().remove(player.getAvatar());

        avatarComboBox.getItems().add(player.getAvatar().getId());
        Collections.sort(avatarComboBox.getItems());
    }

    /**
     * Setup {@link #avatarComboBox} with all avatars.
     */
    private void populateComboBox() {
        List<String> avatars = new ArrayList<>();

        for (int i = 1; i <= NUM_AVATARS; i++) {
            avatars.add("avatar" + i + ".png");
        }

        ObservableList<String> avatarList = FXCollections.observableArrayList();
        avatarList.addAll(avatars);

        avatarComboBox.setItems(avatarList);
        avatarComboBox.setCellFactory(c -> new AvatarListCell());
        avatarComboBox.setButtonCell(new AvatarListCell());
        avatarComboBox.getSelectionModel().selectFirst();
    }

    @Override
    protected void loadPane(String fileName) {
        super.loadPane(fileName, anchorPane);
    }

    public static FrontPageController getInstance() {
        return INSTANCE;
    }
}
