package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AvatarListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FrontPageController extends Controller{
    @FXML public Button addButton, playButton, quitButton;
    @FXML public TextField nameTextField;
    @FXML public ComboBox<String> avatarComboBox;
    @FXML public ListView namesListView;
    @FXML public AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> addButton.setDisable(newValue.isEmpty()));

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
