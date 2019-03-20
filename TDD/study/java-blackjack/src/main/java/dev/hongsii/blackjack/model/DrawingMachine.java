package dev.hongsii.blackjack.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DrawingMachine {

    private Deck deck;

    public void draw(int drawCount, CardReceiver cardReceiver) {
        for (int count = 1; count <= drawCount; count++) {
            cardReceiver.receive(deck.draw());
        }
    }
}
