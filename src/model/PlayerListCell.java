package model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

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

    public PlayerListCell(String name) {
        super();

        _name.setText("    " + name);
        _name.setMaxWidth(Double.MAX_VALUE);
        _name.setTranslateY(7.5); // Place text roughly in the centre
        HBox.setHgrow(_name, Priority.ALWAYS);

        _edit.getStyleClass().add("edit-delete");
        _edit.setOnMouseEntered(event -> _edit.setStyle("-fx-background-color: #fbb03b; -fx-text-fill: white"));
        _edit.setOnMouseExited(event -> _edit.setStyle("")); // Reset style to that in the stylesheet

        _delete.getStyleClass().add("edit-delete");
        _delete.setId("deleteButton");
        _delete.setOnMouseEntered(event -> _delete.setStyle("-fx-background-color: red; -fx-text-fill: white"));
        _delete.setOnMouseExited(event -> _delete.setStyle(""));

        this.getChildren().addAll(_name, _edit, _delete);
    }

    @Override
    public String toString() {
        return _name.getText();
    }
}
