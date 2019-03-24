package dev.hongsii.blackjack.model.result;

public class Push implements WinningResult {

    @Override
    public int getWinningMoney(int bettingMoney) {
        return bettingMoney;
    }
}
