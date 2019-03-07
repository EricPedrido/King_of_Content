package model.tiles;

import model.Player;

public class DirectEffectTile extends Tile{

    private int _effectMoney;
    private int _effectFans;

    public DirectEffectTile(int x, int y) {
        this(x,y, 7500, -30000);
    }

    public DirectEffectTile(int x, int y, int effectMoney, int effectFans) {
        super(x, y);
        _effectMoney = effectMoney;
        _effectFans = effectFans;
    }

    @Override
    public void onLand(Player player) {
        player.addMoney(_effectMoney);
        player.addFans(_effectFans);
    }
}
