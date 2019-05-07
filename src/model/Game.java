package model;

import controllers.PlayPageController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private List<Player> _players;
    private Player _currentPlayer;
    private int _counter;
    private int _roll;

    private static Game INSTANCE = new Game();

    public void newGame(List<Player> players) {
        _players = players;
        _counter = 0;
        _currentPlayer = _players.get(0);
    }

    public void nextTurn() {
        if (_counter == _players.size()) {
            _counter = 0;
        } else {
            _counter++;
        }
        _currentPlayer = _players.get(_counter);
    }

    public void syncPlayerOrder(List<Tab> tabs) {
        List<Player> newPlayers = new ArrayList<>(_players);
        int i=0,j=0;

        while (i < tabs.size()) {
            if (_players.get(i).equals(tabs.get(j).getText())) {
                newPlayers.set(j, _players.get(i));
                i++;
                j=0;
            } else {
                j++;
            }
        }

        _players = newPlayers;
    }

    public Queue<Integer> roll() {
        Queue<Integer> output = new LinkedList<>();
        PlayPageController.getInstance().disableButtons(true);

        int rollOne = (int) ((Math.random()*6)+1);
        int rollTwo = (int) ((Math.random()*6)+1);

        _roll = rollOne + rollTwo;

        output.add(rollOne);
        output.add(rollTwo);
        output.add(_roll);

        _currentPlayer.addRolled(_roll);

        return output;
    }

    public Player getCurrentPlayer() {
        return _currentPlayer;
    }

    public List<Player> getPlayers() {
        return _players;
    }

    public static Game getInstance() {
        return INSTANCE;
    }
}
