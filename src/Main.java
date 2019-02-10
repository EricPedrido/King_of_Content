import controllers.Controller;
import controllers.FrontPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("front_page.fxml"));
        primaryStage.setTitle("King of Content");
        primaryStage.setScene(new Scene(root, 1280, 720));

        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            event.consume();

            Parent quit;
            try {
                quit = FXMLLoader.load(getClass().getResource("/quit.fxml"));
                Stage stage = Controller.createPopUp(quit, "Are your sure", 400, 250);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setAlwaysOnTop(true);

                stage.show();

                if (FrontPageController.getInstance() == null) {
                    // TODO MAKE THE OTHER PAGE RECTANGLE GO
                } else {
                    FrontPageController.getInstance().setQuitBoxOpacity(false);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
