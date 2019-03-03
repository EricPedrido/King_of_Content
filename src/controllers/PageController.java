package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public abstract class PageController extends Controller {
    public void setQuitBoxOpacity(boolean visible, Rectangle quitRectangle) {
        quitRectangle.setVisible(visible);
    }

    public abstract void setQuitBoxOpacity(boolean transparent);

    /**
     * Loads an FXML file into the stage.
     *
     * @param fileName which FXML file to load
     * @param pane     the pane with which to load the FXML
     */
    protected void loadPane(String fileName, AnchorPane pane) {
        Parent newPane;
        try {
            newPane = FXMLLoader.load(getClass().getResource(fileName));
            pane.getChildren().setAll(newPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Let the instantiated controller call {@link #loadPane(String, AnchorPane)}
     * by accessing their AnchorPane, allowing the system to know which stage to load
     * the FXML file to load into.
     */
    protected abstract void loadPane(String fileName);
}
