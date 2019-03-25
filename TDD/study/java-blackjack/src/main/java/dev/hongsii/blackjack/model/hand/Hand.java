package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public abstract class Hand {

    protected Cards cards;

    public static Ready ready() {
        return Ready.getInstance();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public boolean isSameScore(Hand hand) {
        return isSameScore(hand.getTotalScore());
    }

    public boolean isSameScore(int score) {
        return cards.isSameScore(score);
    }

    public boolean isLargerScore(Hand hand) {
        return isLargerScore(hand.getTotalScore());
    }

    public boolean isLargerScore(int score) {
        return cards.isLagerThan(score);
    }

    @Deprecated
    public int getWinningMoney(int money) {
        double winningMoney = money + (money * getWinningMoneyRate());
        return (int) Math.round(winningMoney);
    }

    public int getTotalScore() {
        return cards.getTotalScore();
    }

    public abstract Hand add(Card card);
    public abstract double getWinningMoneyRate();
    public abstract boolean isGameOver();
    public abstract boolean isBlackjack();
    public abstract boolean isBust();
}
