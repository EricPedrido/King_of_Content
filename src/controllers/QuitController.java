package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuitController extends Controller {

    @FXML public Text yesText, noText;

    private final Paint ORANGE = Color.valueOf("#fbb03b");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yesText.setOnMouseEntered(event -> yesText.setFill(ORANGE));
        yesText.setOnMouseExited(event -> yesText.setFill(Color.WHITE));
        yesText.setOnMouseClicked(event -> Platform.exit());

        noText.setOnMouseEntered(event -> noText.setFill(ORANGE));
        noText.setOnMouseExited(event -> noText.setFill(Color.WHITE));
        noText.setOnMouseClicked(event -> cancel());
    }

    private void cancel() {
        Stage stage = (Stage) noText.getScene().getWindow();
        stage.close();

        FrontPageController.getInstance().setQuitBoxOpacity(true);
    }

    @Override
    protected void loadPane(String fileName) {

    }

}
