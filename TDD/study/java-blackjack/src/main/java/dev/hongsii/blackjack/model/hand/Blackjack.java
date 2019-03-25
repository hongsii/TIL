package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Blackjack extends Hand {

    public static final int SCORE = 21;
    private static final int COUNT_OF_CARDS = 2;

    private Blackjack(Cards cards, int bettingMoney) {
        super(cards, bettingMoney);
    }

    public static Blackjack of(Cards cards) {
        return of(cards, NO_BETTING);
    }

    public static Blackjack of(Cards cards, int bettingMoney) {
        if (!isValid(cards)) {
            throw new IllegalArgumentException(String.format("점수가 %d가 아니거나, 카드의 개수가 %d개가 아닙니다.", SCORE, COUNT_OF_CARDS));
        }
        return new Blackjack(cards, bettingMoney);
    }

    public static boolean isValid(Cards cards) {
        return cards.isSameScore(Blackjack.SCORE) && cards.hasCountOfCards(Blackjack.COUNT_OF_CARDS);
    }

    @Override
    public Hand add(Card card) {
        throw new IllegalStateException("마지막 상태입니다.");
    }

    @Override
    public double getWinningMoneyRate() {
        return 1.5;
    }

    @Override
    public boolean isBlackjack() {
        return true;
    }

    @Override
    public boolean isBust() {
        return false;
    }
}
