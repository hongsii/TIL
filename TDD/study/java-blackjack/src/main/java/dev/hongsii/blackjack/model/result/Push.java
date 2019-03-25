package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Push implements Result {

    private int bettingMoney;

    public static Push from(Hand hand) {
        return of(hand.getBettingMoney());
    }

    public static Push of(int bettingMoney) {
        return new Push(bettingMoney);
    }

    @Override
    public int getWinningMoney() {
        return bettingMoney;
    }

    @Override
    public String getResult() {
        return "PUSH";
    }
}
