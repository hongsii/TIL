package dev.hongsii.blackjack.model.status;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Blackjack implements HandStatus {

    public static final int SCORE = 21;

    public static boolean is(int score) {
        return score == SCORE;
    }

    public static Blackjack getInstance() {
        return SingleTon.instance;
    }

    @Override
    public HandStatus next(int score) {
        throw new IllegalStateException("마지막 상태입니다.");
    }

    private static class SingleTon {

        private static Blackjack instance = new Blackjack();
    }
}
