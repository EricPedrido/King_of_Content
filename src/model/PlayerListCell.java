package model;

import controllers.FrontPageController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;

/**
 * Custom List Cell which contain the label of the name,
 * an edit button, and a delete button.
 *
 * @author Eric Pedrido
 */
public class PlayerListCell extends HBox {
    private Label _name = new Label();

    private final Button _edit = new Button("Edit");
    private final Button _delete = new Button("❌");

    public PlayerListCell(Player player) {
        super();

        _name.setText("    " + player.getName());
        _name.setMaxWidth(Double.MAX_VALUE);
        _name.setTranslateY(7.5); // Place text roughly in the centre
        HBox.setHgrow(_name, Priority.ALWAYS);

        _edit.getStyleClass().add("edit-delete");
        _edit.setOnMouseEntered(event -> _edit.setStyle("-fx-background-color: #fbb03b; -fx-text-fill: white"));
        _edit.setOnMouseExited(event -> _edit.setStyle("")); // Reset style to that in the stylesheet
        _edit.setOnAction(event -> FrontPageController.getInstance().onEditClicked(player, this));

        _delete.getStyleClass().add("edit-delete");
        _delete.setId("deleteButton");
        _delete.setOnMouseEntered(event -> _delete.setStyle("-fx-background-color: red; -fx-text-fill: white"));
        _delete.setOnMouseExited(event -> _delete.setStyle(""));
        _delete.setOnAction(event -> FrontPageController.getInstance().removePlayer(player, this));

        this.getChildren().addAll(_name, _edit, _delete);
    }

    @Override
    public String toString() {
        return _name.getText();
    }
}
