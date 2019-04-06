package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.exception.GameOverException;
import dev.hongsii.blackjack.model.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BlackjackGame {

    public static final int DEFAULT_DRAW_COUNT = 2;
    public static final int ADDITIONAL_DRAW_COUNT = 1;

    private DrawingMachine drawingMachine;
    @Getter
    private Dealer dealer;
    @Getter
    private Player player;

    public BlackjackGame(DrawingMachine drawingMachine, Dealer dealer, Player player) {
        this.drawingMachine = drawingMachine;
        this.dealer = dealer;
        this.player = player;
    }

    public BlackjackGame(DrawingMachine drawingMachine, Dealer dealer, List<Player> players) {
        this.drawingMachine = drawingMachine;
        this.dealer = dealer;
        this.players = players;
    }

    @Getter
    private List<Player> players;

    public static BlackjackGame initializeWithSingleDeck() {
        Deck deck = Deck.ofSingle();
        deck.shuffle();
        return new BlackjackGame(DrawingMachine.of(deck), Dealer.create(), Player.create());
    }

    public static BlackjackGame initializeWithSingleDeck(int countOfPlayer) {
        Deck deck = Deck.ofSingle();
        deck.shuffle();

        List<Player> players = new ArrayList<>(countOfPlayer);
        for (int number = 1; number <= countOfPlayer; number++) {
            players.add(Player.create(number));
        }

        return new BlackjackGame(DrawingMachine.of(deck), Dealer.create(), players);
    }

    public void bet(Player player, int money) {
        player.bet(money);
    }

    public void deal() {
        dealer.reset();
        dealTo(dealer);

        for (Player player : players) {
            dealTo(player);
        }
    }

    private void dealTo(CardReceiver cardReceiver) {
        draw(DEFAULT_DRAW_COUNT, cardReceiver);
    }

    public void hit(CardReceiver cardReceiver) {
        draw(ADDITIONAL_DRAW_COUNT, cardReceiver);
    }

    private void draw(int drawCount, CardReceiver cardReceiver) {
        drawingMachine.draw(drawCount, cardReceiver);
    }

    public void validateHand(CardReceiver cardReceiver) {
        if (!cardReceiver.canReceive()) {
            throw new GameOverException();
        }
    }

    public Result winToDealer(Player player) {
        return player.winTo(dealer);
    }
}
