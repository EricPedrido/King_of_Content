package model.tiles;

import model.Player;

public abstract class Tile {
    protected int _x_pos;
    protected int _y_pos;

    public abstract void onLand(Player player);

    protected Tile(int x, int y) {
        _x_pos = x;
        _y_pos = y;
    }

    public int getX() {
        return _x_pos;
    }

    public int getY() {
        return _y_pos;
    }
}
