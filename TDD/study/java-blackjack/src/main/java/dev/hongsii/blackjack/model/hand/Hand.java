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

    public boolean isSameScore(int score) {
        return cards.isSameScore(score);
    }

    public boolean isLargerThan(Hand hand) {
        return isLargerThan(hand.cards.getTotalScore());
    }

    public boolean isLargerThan(int score) {
        return cards.isLagerThan(score);
    }

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
