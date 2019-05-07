package model.tiles;

import javafx.scene.image.Image;
import model.Player;
import model.BoardPane;

public abstract class Tile {
    protected int _x_pos;
    protected int _y_pos;
    protected int _pane_x;
    protected int _pane_y;
    protected BoardPane _pane;

    public abstract void onLand(Player player);

    protected Tile(int x, int y, int pane_x, int pane_y, BoardPane pane) {
        _x_pos = x;
        _y_pos = y;
        _pane_x = pane_x;
        _pane_y = pane_y;
        _pane = pane;
    }

    public int getPaneX() {
        return _pane_x;
    }

    public int getPaneY() {
        return _pane_y;
    }

    public Image getPaneView() {
        return new Image(_pane.toString());
    }

    public int getX() {
        return _x_pos;
    }

    public int getY() {
        return _y_pos;
    }
}
