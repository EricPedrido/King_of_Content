package model;

import java.util.List;

public class Game {
    private List<Player> _players;

    private static Game INSTANCE;

    private Game(List<Player> players) {
        _players = players;
    }

    public static void newGame(List<Player> players) {
        INSTANCE = new Game(players);
    }

    public List<Player> getPlayers() {
        return _players;
    }

    public static Game getInstance() {
        return INSTANCE;
    }
}
