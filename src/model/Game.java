package model;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Queue<Player> _players;
    private Player _currentPlayer;
    private int _roll;

    private static Game INSTANCE = new Game();

    public static void newGame(Queue<Player> players) {
        INSTANCE._players = players;
    }

    public Queue<Integer> roll() {
        Queue<Integer> output = new LinkedList<>();

        int rollOne = (int) ((Math.random()*6)+1);
        int rollTwo = (int) ((Math.random()*6)+1);
        _roll = rollOne + rollTwo;

        output.add(rollOne);
        output.add(rollTwo);
        output.add(_roll);

        return output;
    }

    public int getRoll() {
        return _roll;
    }

    public Player getCurrentPlayer() {
        return _currentPlayer;
    }

    public Queue<Player> getPlayers() {
        return _players;
    }

    public static Game getInstance() {
        return INSTANCE;
    }
}
