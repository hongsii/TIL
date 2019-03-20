package dev.hongsii.blackjack.model.status;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ready implements HandStatus {

    public static final int SCORE = 0;

    public static Ready getInstance() {
        return SingleTon.instance;
    }

    public static boolean is(int score) {
        return score == SCORE;
    }

    @Override
    public HandStatus next(int score) {
        return Total.of(score);
    }

    private static class SingleTon {

        private static Ready instance = new Ready();
    }
}

