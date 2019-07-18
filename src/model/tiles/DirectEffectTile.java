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
        this(x,y,paneX,paneY,0,0,bPane, null, effectMoney, effectFans);
    }

    public DirectEffectTile(int x, int y, int paneX, int paneY, int cornerPane_x, int cornerPane_y,
                            BoardPane bPane, BoardPane cornerPane, int effectMoney, int effectFans) {
        super(x, y, paneX, paneY, cornerPane_x, cornerPane_y, bPane, cornerPane);
        _effectMoney = effectMoney;
        _effectFans = effectFans;
    }

    @Override
    public void onLand(Player player) {
        player.addMoney(_effectMoney);
        player.addFans(_effectFans);
    }
}
