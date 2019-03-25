package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Ready extends Hand {

    private Ready(int money) {
        super(Cards.initialize(), money);
    }

    public static Ready noBetting() {
        return of(NO_BETTING);
    }

    public static Ready of(int money) {
        return new Ready(money);
    }

    @Override
    public Hand add(Card card) {
        cards.add(card);
        return Normal.of(cards, bettingMoney);
    }

    @Override
    public double getWinningMoneyRate() {
        return 0;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBust() {
        return false;
    }
}

