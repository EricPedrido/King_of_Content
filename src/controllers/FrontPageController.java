package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.AvatarListCell;
import model.Game;
import model.Player;
import model.PlayerListCell;

import java.net.URL;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;

/**
 * Controls front_page.fxml
 *
 * @author Eric Pedrido
 */
public class FrontPageController extends PageController {
    @FXML public Button addButton, playButton, quitButton;
    @FXML public TextField nameTextField;
    @FXML public ComboBox<String> avatarComboBox;
    @FXML public ListView<PlayerListCell> namesListView;
    @FXML public ListView<ImageView> avatarListView;
    @FXML public AnchorPane anchorPane;
    @FXML public ColorPicker colorPicker;
    @FXML public Rectangle color_box1, color_box2, color_box3, color_box4, quitRectangle;

    private static FrontPageController INSTANCE;

    private List<Player> _players;
    private List<Rectangle> _colorBoxes;
    private Queue<Color> _defaultColors;
    private List<Color> _usedColors;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        INSTANCE = this;
        _players = new ArrayList<>();
        _colorBoxes = Arrays.asList(color_box1, color_box2, color_box3, color_box4);
        _defaultColors = new LinkedList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE));
        _usedColors = new ArrayList<>();

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
        // Setup the name, avatar, and color of the player
        String name = nameTextField.getText();
        String avatar = avatarComboBox.getSelectionModel().getSelectedItem();

        ImageView image = new ImageView(new Image(avatar));
        image.setPreserveRatio(true);
        image.setFitHeight(35);
        image.setFitWidth(50);
        image.setId(avatar);

        Color color = colorPicker.getValue();

        Player player = new Player(name, image, color);
        _players.add(player);

        // Add name and avatar to their respective lists
        namesListView.getItems().add(new PlayerListCell(player));
        avatarListView.getItems().add(image);

        // Setup color boxes
        if (color.equals(Color.WHITE)) { // If unchanged, load default color
            Color nextCol = _defaultColors.peek();
            if (_usedColors.contains(nextCol)) {
                _defaultColors.remove();
                _defaultColors.add(nextCol);
            }
            player.setColor(_defaultColors.poll());
            _defaultColors.add(player.getColor());
            _usedColors.add(player.getColor());
        }

        updateColorBoxes();
        colorPicker.setValue(Color.WHITE);

        // Restrict users from exceeding maximum player count
        if (namesListView.getItems().size() == 4) {
            nameTextField.setPromptText("Max Players Reached");
            nameTextField.setDisable(true);
            avatarComboBox.setDisable(true);
        }

        // Prepare UI for next player to add
        nameTextField.setText("");
        addButton.setDisable(true);
        if (namesListView.getItems().size() > 1) {
            playButton.setDisable(false);
        }

        // Ensure each avatar is unique
        avatarComboBox.getItems().remove(avatar);
        avatarComboBox.getSelectionModel().selectFirst();
    }

    /**
     * Exits out of the game
     */
    private void onQuitClicked() {
        quit();
        setQuitBoxOpacity(true);
    }

    /**
     * Creates a new game with the current players and loads the main game window.
     */
    private void onPlayClicked() {
        Game.getInstance().newGame(_players);
        loadPane("/play_page.fxml");
    }

    /**
     * Edit the Player's detail by removing the player altogether,
     * but pre-selecting the Player's attributes.
     *
     * @param player Player that needs to be edited
     * @param cell The cell on the listView which is edited
     */
    public void onEditClicked(Player player, PlayerListCell cell) {
        removePlayer(player, cell);

        nameTextField.setText(player.getName());
        avatarComboBox.getSelectionModel().select(player.getAvatar().getId());
        colorPicker.setValue(player.getColor());
    }

    /**
     * Matches the players' color boxes with their position on the list.
     */
    private void updateColorBoxes() {
        // Reset all color boxes
        for (Rectangle colorBox : _colorBoxes) {
            colorBox.setVisible(false);
        }

        // Set the color of each box to match the player in that position
        for (int i = 0; i < _players.size(); i++) {
            Rectangle currentBox = _colorBoxes.get(i);
            currentBox.setVisible(true);
            currentBox.setFill(_players.get(i).getColor());
        }
    }

    /**
     * Removes the Player from the system and from the UI
     *
     * @param player Player to remove
     * @param cell Cell where the player was removed from
     */
    public void removePlayer(Player player, PlayerListCell cell) {
        // Remove player from system
        _players.remove(player);
        _usedColors.remove(player.getColor());

        updateColorBoxes();

        // Visibly remove the player from the UI
        namesListView.getItems().remove(cell);
        avatarListView.getItems().remove(player.getAvatar());

        // Return the removed player's avatar to the avatar comboBox
        avatarComboBox.getItems().add(player.getAvatar().getId());
        Collections.sort(avatarComboBox.getItems());

        // Reset the components
        nameTextField.setPromptText("Enter Name Here...");
        nameTextField.setDisable(false);
        avatarComboBox.setDisable(false);
        if (namesListView.getItems().size() < 2) {
            playButton.setDisable(true);
        }
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
    public void setQuitBoxOpacity(boolean visible) {
        quitRectangle.setVisible(visible);
        anchorPane.setDisable(visible);
    }

    @Override
    protected void loadPane(String fileName) {
        super.loadPane(fileName, anchorPane);
    }

    public static FrontPageController getInstance() {
        return INSTANCE;
    }
}
