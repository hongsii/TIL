package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Dealer {

    public static final int SCORE_FOR_DRAW = 17;
    public static final int DEFAULT_DRAW_COUNT = 2;

    private Hands hands;

    public static Dealer create() {
        return new Dealer();
    }

    public static Dealer of(Hands hands) {
        return new Dealer(hands);
    }

    public void draw(Deck deck) {
        hands = Hands.initialize();
        drawByDefaultDrawCount(deck);
        if (canDrawAdditional()) {
            hands.addCard(deck.draw());
        }
    }

    private void drawByDefaultDrawCount(Deck deck) {
        for (int i = 0; i < DEFAULT_DRAW_COUNT; i++) {
            hands.addCard(deck.draw());
        }
    }

    private boolean canDrawAdditional() {
        return hands.getTotalScore() < SCORE_FOR_DRAW;
    }

    public List<Card> getCards() {
        return hands.getCards();
    }
}
