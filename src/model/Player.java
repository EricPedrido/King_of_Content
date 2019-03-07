package model;


import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Player {
    private String _name;
    private ImageView _avatar;
    private Color _color;
    private int _money;
    private int _fans;

    private final static int START_MONEY = 75000;
    private final static int START_FANS = 0;

    public Player(String name, ImageView avatar, Color color) {
        _name = name;
        _avatar = avatar;
        _color = color;

        _money = START_MONEY;
        _fans = START_FANS;
    }

    public void setPosition(int x, int y) {
        _avatar.setX(x);
        _avatar.setY(y);
    }

    public void addMoney(int add) {
        _money += add;
    }

    public void addFans(int add) {
        if ((_fans + add) >= 1000000) {
            // TODO WIN THE GAME
        } else if ((_fans + add) <= 0) {
            _fans = 0;
        } else {
            _fans += add;
        }
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

    public int getMoney() {
        return _money;
    }

    public int getFans() {
        return _fans;
    }

    public String getColorAsString() {
        return "#" + _color.toString().substring(2,8);
    }

    public String getFirstName() {
        if (_name.contains(" ")) {
            return _name.substring(0, _name.indexOf(' '));
        } else {
            return _name;
        }
    }

    public ImageView getAvatar() {
        return _avatar;
    }
}
