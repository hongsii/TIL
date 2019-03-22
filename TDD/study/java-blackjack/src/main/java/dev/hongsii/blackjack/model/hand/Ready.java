package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

import java.util.Collections;

public class Ready extends Hand {

    private Ready() {
        super(Cards.of(Collections.emptyList()));
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

