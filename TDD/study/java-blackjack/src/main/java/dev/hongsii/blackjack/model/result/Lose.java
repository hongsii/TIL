package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Lose implements Result {

    private int bettingMoney;

    public static Result from(Hand hand) {
        return of(hand.getBettingMoney());
    }

    public static Lose of(int bettingMoney) {
        return new Lose(bettingMoney);
    }

    @Override
    public int getWinningMoney() {
        return 0;
    }

    @Override
    public String getResult() {
        return "LOSE";
    }
}
