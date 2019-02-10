package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Ensures that all controllers are able to switch between stages while
 * reducing duplicate code.
 *
 * @author Eric Pedrido
 */
public abstract class Controller implements Initializable {
    @FXML public Rectangle quitRectangle;

    protected static final int NUM_AVATARS = 8;

    public void setQuitBoxOpacity(boolean transparent) {
        if (transparent) {
            quitRectangle.setOpacity(0.0);
        } else {
            quitRectangle.setOpacity(0.5);
        }
    }

    /**
     * Loads a <q>.fxml</q> file into a new window.
     * Any invocation of this method must show the stage.
     * Showing of the stage is not implemented in this method
     * to allow for more options to be added to the stage.
     *
     * @param fileName  the name of the <q>.fxml</q> file.
     * @param title  the title of the window.
     * @param width  width of the window.
     * @param height height of the window.
     */
    protected Stage createPopUp(String fileName, String title, int width, int height) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(fileName));

            return createPopUp(root, title, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Stage createPopUp(Parent root, String title, int width, int height) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.setResizable(false);

        return stage;
    }

    protected void quit() {
        Stage stage = createPopUp("/quit.fxml", "Are you sure", 400, 250);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

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
