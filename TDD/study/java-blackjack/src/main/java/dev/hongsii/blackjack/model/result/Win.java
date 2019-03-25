package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Win implements Result {

    private Hand hand;

    public static Win of(Hand hand) {
        return new Win(hand);
    }

    @Override
    public int getWinningMoney(int bettingMoney) {
        double winningMoney = bettingMoney + (bettingMoney * hand.getWinningMoneyRate());
        return (int) Math.round(winningMoney);
    }

    @Override
    public String getResult() {
        return "WIN";
    }
}
