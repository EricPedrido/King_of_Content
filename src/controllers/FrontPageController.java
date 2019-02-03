package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.AvatarListCell;
import model.PlayerListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FrontPageController extends Controller{
    @FXML public Button addButton, playButton, quitButton;
    @FXML public TextField nameTextField;
    @FXML public ComboBox<String> avatarComboBox;
    @FXML public ListView<PlayerListCell> namesListView;
    @FXML public ListView<ImageView> avatarListView;
    @FXML public AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PlayerListCell> emptyPlayers = FXCollections.observableArrayList();
        ObservableList<ImageView> emptyAvatars = FXCollections.observableArrayList();
        namesListView.setItems(emptyPlayers);
        avatarListView.setItems(emptyAvatars);

        populateComboBox();

        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> addButton.setDisable(newValue.isEmpty()));
        addButton.setOnAction(event -> onAddClicked());
    }

    private void onAddClicked() {
        String avatar = avatarComboBox.getSelectionModel().getSelectedItem();
        ImageView image = new ImageView(new Image(avatar));
        image.setPreserveRatio(true);
        image.setFitHeight(30);
        image.setFitWidth(50);

        namesListView.getItems().add(new PlayerListCell(nameTextField.getText()));
        avatarListView.getItems().add(image);

        if (namesListView.getItems().size() == 4) {
            nameTextField.setPromptText("Max Players Reached");
            nameTextField.setDisable(true);
            avatarComboBox.setDisable(true);
        }

        nameTextField.setText("");
        addButton.setDisable(true);
        playButton.setDisable(false);

        avatarComboBox.getItems().remove(avatar);
        avatarComboBox.getSelectionModel().selectFirst();
    }

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
}
