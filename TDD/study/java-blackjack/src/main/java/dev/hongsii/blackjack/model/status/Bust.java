package dev.hongsii.blackjack.model.status;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Bust implements HandStatus {

    public static Bust getInstance() {
        return SingleTon.instance;
    }

    public static boolean is(int score) {
        return score > Blackjack.SCORE;
    }

    @Override
    public HandStatus next(int score) {
        throw new IllegalStateException("마지막 상태입니다.");
    }

    private static class SingleTon {

        private static Bust instance = new Bust();
    }
}
