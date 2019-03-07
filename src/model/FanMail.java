package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FanMail {

    private int _rewardMoney;
    private int _rewardFans;
    private int _declineFans;
    private int _failMoney;
    private int _failFans;

    private int _minRoll;

    private static final List<FanMail> FAN_MAIL_LIST = new ArrayList<>(Arrays.asList(
            new FanMail(-5000, 10000,-5000, -5000, -10000, 6),
            new FanMail(2500, 10000, 0, 0, 0, 0),
            new FanMail(0, -5000, -5000, 0, 0, 0),
            new FanMail(-10000, 20000, -10000, -5000, -20000, 7),
            new FanMail(0, -50000, -50000, 0, 0, 0),
            new FanMail(50000, 50000, -10000, 0, -20000, 8),
            new FanMail(0, 50000, -10000, 0, -15000, 7),
            new FanMail(0, -1, -1, 0, 0, 0),
            new FanMail(0, -5000, -5000, 0, 0, 0)));
    
    public FanMail(int rewardMoney, int rewardFans, int declineFans, int failMoney, int failFans, int minRoll) {
        _rewardMoney = rewardMoney;
        _rewardFans = rewardFans;
        _declineFans = declineFans;
        _failMoney = failMoney;
        _failFans = failFans;
        _minRoll = minRoll;
    }

    public static FanMail retrieve() {
        return FAN_MAIL_LIST.get(new Random().nextInt(FAN_MAIL_LIST.size()));
    }

    public boolean isChallenge() {
        return _minRoll != 0;
    }

    public void accept(Player player, int roll) {
        if (roll >= _minRoll) { // Get reward
            player.addMoney(_rewardMoney);
            player.addFans(_rewardFans);
        } else {
            player.addMoney(_failMoney);
            player.addFans(_failFans);
        }
    }

    public void decline(Player player) {
        player.addFans(_declineFans);
    }
}
