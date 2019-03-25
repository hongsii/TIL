package dev.hongsii.blackjack.model.result;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Push implements Result {

    public static Push getInstance() {
        return Singleton.instance;
    }

    @Override
    public int getWinningMoney(int bettingMoney) {
        return bettingMoney;
    }

    @Override
    public String getResult() {
        return "PUSH";
    }

    private static class Singleton {

        private static Push instance = new Push();
    }
}
