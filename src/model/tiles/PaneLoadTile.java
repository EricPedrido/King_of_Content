package model.tiles;

import model.BoardPane;
import model.Player;

public class PaneLoadTile extends Tile {

    private Pane _pane;

    public PaneLoadTile(int x, int y, int paneX, int paneY, BoardPane bPane, Pane pane) {
        this(x,y,paneX,paneY,0,0,bPane,null,pane);
    }

    public PaneLoadTile(int x, int y, int paneX, int paneY, int cornerPane_x, int cornerPane_y,
                        BoardPane bPane, BoardPane cornerPane, Pane pane) {
        super(x,y,paneX,paneY,cornerPane_x, cornerPane_y, bPane, cornerPane);
        _pane = pane;
    }

    @Override
    public void onLand(Player player) {
        if (_pane.toString().equals("")) {
            System.out.println("PaneChanged:" + _pane.toString());
        }
    }
}
