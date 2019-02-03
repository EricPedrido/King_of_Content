package model;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class AvatarListCell extends ListCell<String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        setText(null);

        if (item != null) {
            ImageView imageView = new ImageView(new Image(item));
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(50);
            imageView.setFitHeight(40);
            setGraphic(imageView);
        }
    }
}
