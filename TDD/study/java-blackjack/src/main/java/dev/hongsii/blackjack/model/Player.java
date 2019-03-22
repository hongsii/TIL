package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player implements CardReceiver {

    private Hand hand;

    public static Player create() {
        return of(Hand.ready());
    }

    public static Player of(Hand hand) {
        return new Player(hand);
    }

    @Override
    public void receive(Card card) {
        hand = hand.add(card);
    }

    public List<Card> getCards() {
        return hand.getCards();
    }
}
