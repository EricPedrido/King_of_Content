package model.tiles;

public enum Pane {
    FAN_MAIL("fan_mail"), RISK("risk"), MEDIA_STORM("media_storm"), PURCHASABLE("purchasable"),
    //TODO FIGURE ALL THIS SHIT OUT
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
