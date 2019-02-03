package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Ensures that all controllers are able to switch between stages while
 * reducing duplicate code.
 *
 * @author Eric Pedrido
 */
public abstract class Controller implements Initializable {
    protected static final int NUM_AVATARS = 8;

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
