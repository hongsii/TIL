package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.exception.GameOverException;
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
        Deck deck = Deck.ofSingle();
        deck.shuffle();
        return new BlackjackGame(DrawingMachine.of(deck), Dealer.create(), Player.create());
    }

    public void bet(Player player, int money) {
        player.bet(money);
    }

    public void deal() {
        dealTo(dealer);
        dealTo(player);
    }

    private void dealTo(CardReceiver cardReceiver) {
        cardReceiver.ready();
        draw(DEFAULT_DRAW_COUNT, cardReceiver);
    }

    public void hit(CardReceiver cardReceiver) {
        draw(ADDITIONAL_DRAW_COUNT, cardReceiver);
    }

    private void draw(int drawCount, CardReceiver cardReceiver) {
        drawingMachine.draw(drawCount, cardReceiver);
    }

    public void validateHand(CardReceiver cardReceiver) {
        if (cardReceiver.isGameOver()) {
            throw new GameOverException();
        }
    }

    public boolean winToDealer(Player player) {
        return player.winTo(dealer);
    }
}
