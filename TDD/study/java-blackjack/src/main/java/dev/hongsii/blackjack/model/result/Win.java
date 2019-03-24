package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Win implements WinningResult {

    private Hand hand;

    @Override
    public int getWinningMoney(int bettingMoney) {
        double winningMoney = bettingMoney + (bettingMoney * hand.getWinningMoneyRate());
        return (int) Math.round(winningMoney);
    }
}
