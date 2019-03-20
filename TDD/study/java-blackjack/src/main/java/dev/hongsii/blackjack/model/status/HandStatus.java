package dev.hongsii.blackjack.model.status;

public interface HandStatus {

    static HandStatus of(int score) {
        if (Blackjack.is(score)) {
            return Blackjack.getInstance();
        }
        if (Bust.is(score)) {
            return Bust.getInstance();
        }
        if (Ready.is(score)) {
            return Ready.getInstance();
        }
        return Total.of(score);
    }

    HandStatus next(int score);
}
