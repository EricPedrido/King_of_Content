package model;


import controllers.PlayPageController;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.tiles.Tile;

import java.util.Timer;
import java.util.TimerTask;

import static model.Board.UPLOAD;

public class Player {
    private String _name;
    private ImageView _avatar;
    private Color _color;
    private int _money;
    private int _fans;
    private int _position;
    private Tab _tab;

    private int _index;

    private final static int START_MONEY = 75000;
    private final static int START_FANS = 0;
    private final static int START_FIT_HEIGHT = 22;
    private final static int START_FIT_WIDTH = 26;

    public Player(String name, ImageView avatar, Color color) {
        _name = name;
        _avatar = avatar;
        _color = color;

        _money = START_MONEY;
        _fans = START_FANS;
        _position = 0;
        _index = 0;
    }

    public void setStartingPosition() {
        _avatar.setFitHeight(START_FIT_HEIGHT);
        _avatar.setFitWidth(START_FIT_WIDTH);
        this.setPosition(UPLOAD.getX(), UPLOAD.getY());
    }

    public void addRolled(int roll) {
        final int boardSize = Board.values().length;

        if ((_position + roll) < (boardSize - 1)) { // In case the player is about to pass "upload"
            _position += roll;
        } else {
            _position = boardSize - roll;
        }

        positionAnimation();
    }

    public void setPosition(int x, int y) {
        _avatar.setX(x-10);
        _avatar.setY(y-2);
    }

    private void positionAnimation() {
        Board[] board = Board.values();
        Player player = this;

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Board boardPos = board[_index];
                setPosition(boardPos.getX(), boardPos.getY());
                if (board[_index] == board[_position]) {
                    timer.cancel();
                    boardPos.onLand(player);
                    PlayPageController.getInstance().disableButtons(false);
                } else {
                    if ((_index + 1) == (board.length - 1)) {
                        _index = 0;
                    } else {
                        _index++;
                    }
                }
            }
        }, 0, 300);
    }

    public void addMoney(int add) {
        _money += add;
    }

    public void addFans(int add) {
        if ((_fans + add) >= 1000000) {
            // TODO WIN THE GAME
            System.out.println("Winner: " + _name);
        } else if ((_fans + add) <= 0) {
            _fans = 0;
        } else {
            _fans += add;
        }
    }

    public void setTab(Tab tab) {
        _tab = tab;
    }

    public void setColor(Color color) {
        _color = color;
    }

    public Tab getTab() {
        return _tab;
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
