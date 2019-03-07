package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Risk {

    private static final List<Risk> RISK_LIST = new ArrayList<>(Arrays.asList(
            new Risk() {
                @Override
                public void effect(Player player) {
                    player.addMoney(-3000);
                    player.addFans(5000);
                }
            },
            new Risk() {
                @Override
                public void effect(Player player) {
                    player.addFans(50000);
                }
            },
            new Risk() {
                @Override
                public void effect(Player player) {
                    player.addFans(-50000);
                    //Set position to media storm
                }
            }));

    public abstract void effect(Player player);
}
