package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

public class Ready extends Hand {

    private Ready() {
        super(null);
    }

    public static Ready getInstance() {
        return SingleTon.instance;
    }

    @Override
    public Hand add(Card card) {
        Cards newCards = Cards.initialize();
        newCards.add(card);
        return Normal.of(newCards);
    }

    private static class SingleTon {

        private static Ready instance = new Ready();
    }
}

