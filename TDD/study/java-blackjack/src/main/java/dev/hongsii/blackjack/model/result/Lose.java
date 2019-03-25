package dev.hongsii.blackjack.model.result;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Lose implements Result {

    public static Lose getInstance() {
        return Singleton.instance;
    }

    @Override
    public int getWinningMoney(int bettingMoney) {
        return -bettingMoney;
    }

    @Override
    public String getResult() {
        return "LOSE";
    }

    private static class Singleton {

        private static final Lose instance = new Lose();
    }
}
