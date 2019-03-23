package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player implements CardReceiver {

    public static final int DEFAULT_MONEY = 500;

    private Hand hand;
    private int money;
    private int bettingMoney = 0;

    public static Player create() {
        return of(Hand.ready());
    }

    public static Player of(Hand hand) {
        return Player.of(hand, DEFAULT_MONEY);
    }

    public static Player of(Hand hand, int money) {
        return new Player(hand, money, 0);
    }

    public void bet(int money) {
        this.bettingMoney = money;
        this.money -= bettingMoney;
    }

    @Override
    public void ready() {
        hand = Hand.ready();
    }

    @Override
    public void receive(Card card) {
        hand = hand.add(card);
    }

    @Override
    public boolean isGameOver() {
        return hand.isGameOver();
    }

    public boolean winTo(CardMatcher cardMatcher) {
        boolean isWin = !cardMatcher.win(hand);
        if (isWin) {
            money += hand.getWinningMoney(bettingMoney);
        }
        return isWin;
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getMoney() {
        return money;
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
