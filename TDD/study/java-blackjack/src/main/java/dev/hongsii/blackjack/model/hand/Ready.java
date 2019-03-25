package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

import java.util.Collections;

public class Ready extends Hand {

    private Ready() {
        super(Cards.of(Collections.emptyList()));
    }

    public static Ready getInstance() {
        return Singleton.instance;
    }

    @Override
    public Hand add(Card card) {
        Cards newCards = Cards.initialize();
        newCards.add(card);
        return Normal.of(newCards);
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

    private static class Singleton {

        private static final Ready instance = new Ready();
    }
}

