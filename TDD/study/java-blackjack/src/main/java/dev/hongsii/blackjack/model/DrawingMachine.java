package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawingMachine {

    private Deck deck;

    public static DrawingMachine of(Deck deck) {
        return new DrawingMachine(deck);
    }

    public void draw(int drawCount, CardReceiver cardReceiver) {
        for (int count = 1; count <= drawCount; count++) {
            cardReceiver.receive(deck.draw());
        }
    }
}
