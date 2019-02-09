package model;


import javafx.scene.image.ImageView;

public class Player {
    private String _name;
    private ImageView _avatar;

    public Player(String name, ImageView avatar) {
        _name = name;
        _avatar = avatar;
    }

    public String getName() {
        return _name;
    }

    public ImageView getAvatar() {
        return _avatar;
    }
}
