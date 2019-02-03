package model;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

public class PlayerListCell extends HBox {
    private Label _name = new Label();

    private final Button _edit = new Button("Edit");
    private final Button _delete = new Button("❌");

    public PlayerListCell(String name) {
        super();

        _name.setText("    " + name);
        _name.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(_name, Priority.ALWAYS);

        _delete.setTextFill(Color.RED);

        this.getChildren().addAll(_name, _edit, _delete);
    }

}
