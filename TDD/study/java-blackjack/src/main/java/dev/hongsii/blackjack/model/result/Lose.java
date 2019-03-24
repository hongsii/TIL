package dev.hongsii.blackjack.model.result;

public class Lose implements WinningResult {

    @Override
    public int getWinningMoney(int bettingMoney) {
        return -bettingMoney;
    }
}
