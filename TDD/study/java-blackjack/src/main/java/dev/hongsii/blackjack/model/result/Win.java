package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Win implements Result {

    private int bettingMoney;
    private double winningMoneyRate;

    public static Win from(Hand hand) {
        return new Win(hand.getBettingMoney(), hand.getWinningMoneyRate());
    }

    @Override
    public int getWinningMoney() {
        double winningMoney = bettingMoney + (bettingMoney * winningMoneyRate);
        return (int) Math.round(winningMoney);
    }

    @Override
    public String getResult() {
        return "WIN";
    }
}
