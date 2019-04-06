package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Normal extends Hand {

    private Normal(Cards cards, int bettingMoney) {
        super(cards, bettingMoney);
    }

    public static Normal of(Cards cards) {
        return of(cards, NO_BETTING);
    }

    public static Normal of(Cards cards, int bettingMoney) {
        if (cards.getTotalScore() >= Blackjack.SCORE) {
            throw new IllegalArgumentException(String.format("점수는 %d 미만이여야 합니다.", Blackjack.SCORE));
        }
        return new Normal(cards, bettingMoney);
    }

    @Override
    public Hand add(Card card) {
        cards.add(card);
        if (Blackjack.isValid(cards)) {
            return Blackjack.of(cards, bettingMoney);
        }
        if (Bust.isValid(cards)) {
            return Bust.of(cards, bettingMoney);
        }
        return this;
    }

    @Override
    public double getWinningMoneyRate() {
        return 1;
    }

    @Override
    public boolean isBlackjack() {
        return Blackjack.isValid(cards);
    }

    @Override
    public boolean isBust() {
        return Bust.isValid(cards);
    }
}
