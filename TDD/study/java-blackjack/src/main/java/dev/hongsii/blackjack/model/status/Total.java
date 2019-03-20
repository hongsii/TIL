package dev.hongsii.blackjack.model.status;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Total implements HandStatus {

    private static final Map<Integer, Total> CACHE = new HashMap<>();

    private int score;

    public static Total of(int score) {
        if (score >= Blackjack.SCORE) {
            throw new IllegalArgumentException(String.format("점수는 %d 미만이여야 합니다.", Blackjack.SCORE));
        }
        return fromCache(score);
    }

    private static Total fromCache(int score) {
        if (CACHE.containsKey(score)) {
            return CACHE.get(score);
        }
        Total total = new Total(score);
        CACHE.put(score, total);
        return total;
    }

    @Override
    public HandStatus next(int score) {
        int nextScore = sum(score);
        if (isBlackjack(nextScore)) {
            return Blackjack.getInstance();
        }
        if (isBust(nextScore)) {
            return Bust.getInstance();
        }
        return Total.of(nextScore);
    }

    private int sum(int score) {
        return this.score + score;
    }

    private boolean isBlackjack(int score) {
        return score == Blackjack.SCORE;
    }

    private boolean isBust(int score) {
        return score > Blackjack.SCORE;
    }
}
