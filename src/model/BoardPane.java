package model;

public enum BoardPane {
    SIDE_1("1"), SIDE_2("2"), SIDE_3("3"), SIDE_4("4");

    private String _dir;

    BoardPane(String dir) {
        _dir = "/side_" + dir + ".png";
    }

    @Override
    public String toString() {
        return _dir;
    }
}
