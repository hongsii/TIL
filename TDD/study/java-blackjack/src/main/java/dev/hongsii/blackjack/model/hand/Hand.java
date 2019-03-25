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

    protected static final int NO_BETTING = 0;

    protected Cards cards;
    protected int bettingMoney;

    protected Hand(Cards cards) {
        this.cards = cards;
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

    public int getTotalScore() {
        return cards.getTotalScore();
    }

    public boolean isGameOver() {
        return isBlackjack() || isBust();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public int getBettingMoney() {
        return bettingMoney;
    }

    public abstract Hand add(Card card);
    public abstract double getWinningMoneyRate();
    public abstract boolean isBlackjack();
    public abstract boolean isBust();
}
