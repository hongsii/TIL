package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.result.Result;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BlackjackGame {

    public static final int DEFAULT_DRAW_COUNT = 2;
    public static final int ADDITIONAL_DRAW_COUNT = 1;

    private DrawingMachine drawingMachine;
    @Getter
    private Dealer dealer;
    @Getter
    private List<Player> players;
    private BettingTable bettingTable;

    public static BlackjackGame initializeWithSingleDeck(int countOfPlayer) {
        Deck deck = Deck.ofSingle();
        deck.shuffle();

        List<Player> players = createPlayers(countOfPlayer);

        return new BlackjackGame(DrawingMachine.of(deck), Dealer.create(), players, new BettingTable());
    }

    private static List<Player> createPlayers(int countOfPlayer) {
        List<Player> players = new ArrayList<>(countOfPlayer);
        for (int number = 1; number <= countOfPlayer; number++) {
            players.add(Player.create(number));
        }
        return players;
    }

    public void betOnTable(Player player, int bettingMoney) {
        bettingTable.bet(player, bettingMoney);
    }

    public void deal(CardReceiver cardReceiver) {
        cardReceiver.clear();
        drawingMachine.draw(DEFAULT_DRAW_COUNT, cardReceiver);
    }

    public void hit(CardReceiver cardReceiver) {
        drawingMachine.draw(ADDITIONAL_DRAW_COUNT, cardReceiver);
    }

    public Result winToDealer(Player player) {
        Result result = player.winTo(dealer);
        int winningMoney = result.calculateWinningMoney(bettingTable.getBettingMoney(player));
        player.applyWinningMoney(winningMoney);
        return result;
    }
}
