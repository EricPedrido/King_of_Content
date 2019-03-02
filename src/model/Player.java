package model;


import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player {
    private String _name;
    private ImageView _avatar;
    private Color _color;
    private int _money;
    private int _fans;

    private final static int START_MONEY = 75000;
    private final static int START_FANS = 50000;

    public Player(String name, ImageView avatar, Color color) {
        _name = name;
        _avatar = avatar;
        _color = color;

        _money = START_MONEY;
        _fans = START_FANS;
    }

    public void setColor(Color color) {
        _color = color;
    }

    public String getName() {
        return _name;
    }

    public Color getColor() {
        return _color;
    }

    public String getFirstName() {
        return _name.substring(_name.indexOf(' '));
    }

    public ImageView getAvatar() {
        return _avatar;
    }
}
