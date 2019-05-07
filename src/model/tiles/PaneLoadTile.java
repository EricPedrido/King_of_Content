package model.tiles;

import controllers.PlayPageController;
import model.BoardPane;
import model.Player;

public class PaneLoadTile extends Tile {

    private Pane _pane;

    public PaneLoadTile(int x, int y, int paneX, int paneY, BoardPane bPane, Pane pane) {
        super(x, y, paneX, paneY, bPane);
        _pane = pane;
    }

    @Override
    public void onLand(Player player) {
        if (_pane.toString().equals("")) {
            System.out.println("PaneChanged:" + _pane.toString());
        } else {
            PlayPageController.getInstance().loadPane(_pane);
        }
    }
}
