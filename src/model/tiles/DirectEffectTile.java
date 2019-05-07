package model.tiles;

import model.BoardPane;
import model.Player;

public class DirectEffectTile extends Tile{

    private int _effectMoney;
    private int _effectFans;

    public DirectEffectTile(int x, int y, int paneX, int paneY, BoardPane bPane) {
        this(x,y, paneX, paneY, bPane, 7500, -30000);
    }

    public DirectEffectTile(int x, int y, int paneX, int paneY, BoardPane bPane, int effectMoney, int effectFans) {
        super(x, y, paneX, paneY, bPane);
        _effectMoney = effectMoney;
        _effectFans = effectFans;
    }

    @Override
    public void onLand(Player player) {
        player.addMoney(_effectMoney);
        player.addFans(_effectFans);
    }
}
