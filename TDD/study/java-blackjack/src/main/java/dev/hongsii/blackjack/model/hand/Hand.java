package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class Hand {

    protected Cards cards;

    public static Ready ready() {
        return Ready.getInstance();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public boolean isSameScore(int score) {
        return cards.isSameScore(score);
    }

    public boolean isLargerThan(Hand hand) {
        return cards.isLagerThan(hand.cards.getTotalScore());
    }

    public boolean isBust() {
        return this.getClass() == Bust.class;
    }

    public abstract Hand add(Card card);
}
