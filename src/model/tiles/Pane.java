package model.tiles;

public enum Pane {
    ROLL("roll"), FAN_MAIL("fan_mail"), RISK("risk"), MEDIA_STORM("media_storm"), PURCHASABLE("purchasable"),
    //TODO Define classes for these types of Panes
    CONT_CON(""), TEMP("");

    private String _dir;

    Pane(String dir) {
        _dir = "/play_" + dir + ".fxml";
    }

    @Override
    public String toString() {
        return _dir;
    }
}
