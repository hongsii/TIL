package dev.hongsii.blackjack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BlackjackGame {

    public static final int DEFAULT_DRAW_COUNT = 2;
    public static final int ADDITIONAL_DRAW_COUNT = 1;

    private DrawingMachine drawingMachine;
    @Getter
    private Dealer dealer;
    @Getter
    private Player player;

    public static BlackjackGame initializeWithSingleDeck() {
        return new BlackjackGame(DrawingMachine.of(Deck.ofSingle()), Dealer.create(), Player.create());
    }

    public void deal() {
        drawingMachine.draw(DEFAULT_DRAW_COUNT, dealer);
        drawingMachine.draw(DEFAULT_DRAW_COUNT, player);
    }

    public void hit(CardReceiver cardReceiver) {
        drawingMachine.draw(ADDITIONAL_DRAW_COUNT, cardReceiver);
    }

    public boolean winToDealer(Player player) {
        return player.winTo(dealer);
    }
}
