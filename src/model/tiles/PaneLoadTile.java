package model.tiles;

import controllers.PlayPageController;
import model.Player;

public class PaneLoadTile extends Tile {

    private Pane _pane;

    public PaneLoadTile(int x, int y, Pane pane) {
        super(x, y);
        _pane = pane;
    }

    @Override
    public void onLand(Player player) {
        if (!_pane.toString().equals("")) {
            PlayPageController.getInstance().loadPane(_pane);
        } else {
            System.out.println("PaneChanged");
        }
    }
}
