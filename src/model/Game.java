package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Queue<Player> _players;

    private static Game INSTANCE = new Game();

    public static void newGame(Queue<Player> players) {
        INSTANCE._players = players;
    }

    public Queue<Player> getPlayers() {
        return _players;
    }

    public static Game getInstance() {
        return INSTANCE;
    }
}
