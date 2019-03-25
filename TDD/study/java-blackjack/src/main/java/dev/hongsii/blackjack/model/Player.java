package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.hand.Ready;
import dev.hongsii.blackjack.model.result.Result;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Player implements CardReceiver {

    private Hand hand;
    private Money money;

    public static Player create() {
        return of(Ready.noBetting());
    }

    public static Player of(Hand hand) {
        return Player.of(hand, Money.ofDefault());
    }

    public static Player of(Hand hand, Money money) {
        return new Player(hand, money);
    }

    public void bet(int bettingMoney) {
        money.minus(bettingMoney);
        hand = Ready.of(bettingMoney);
    }

    @Override
    public void receive(Card card) {
        hand = hand.add(card);
    }

    @Override
    public boolean isGameOver() {
        return hand.isGameOver();
    }

    public Result winTo(CardMatcher cardMatcher) {
        Result result = cardMatcher.match(hand);
        money.plus(result.getWinningMoney());
        return result;
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getMoney() {
        return money.getMoney();
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
