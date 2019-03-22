package dev.hongsii.blackjack;

import dev.hongsii.blackjack.model.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlackjackGame {

    public static final int DEFAULT_DRAW_COUNT = 2;
    public static final int ADDITIONAL_DRAW_COUNT = 1;

    private DrawingMachine drawingMachine;
    private Dealer dealer;
    private Player player;

    public static BlackjackGame initializeWithSingleDeck() {
        return new BlackjackGame(DrawingMachine.of(Deck.ofSingle()), Dealer.create(), Player.create());
    }

    public void draw() {
        drawingMachine.draw(DEFAULT_DRAW_COUNT, dealer);
        drawingMachine.draw(DEFAULT_DRAW_COUNT, player);
    }

    public void hit(CardReceiver cardReceiver) {
        drawingMachine.draw(ADDITIONAL_DRAW_COUNT, cardReceiver);
    }

    public boolean deal(Player player) {
        return false;
//        return dealer.deal(player);
    }
}
