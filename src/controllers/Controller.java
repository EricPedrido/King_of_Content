package controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    protected static final int NUM_AVATARS = 8;

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
}
