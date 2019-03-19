package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player {

    public static final int DEFAULT_DRAW_COUNT = 2;

    private Hands hands;

    public static Player create() {
        return new Player();
    }

    public static Player of(Hands hands) {
        return new Player(hands);
    }

    public void draw(Deck deck) {
        hands = Hands.initialize();
        for (int i = 0; i < DEFAULT_DRAW_COUNT; i++) {
            hands.addCard(deck.draw());
        }
    }

    public List<Card> getCards() {
        return hands.getCards();
    }
}
