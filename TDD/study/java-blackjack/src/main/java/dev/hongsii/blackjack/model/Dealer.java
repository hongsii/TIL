package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.result.Lose;
import dev.hongsii.blackjack.model.result.Win;
import dev.hongsii.blackjack.model.result.WinningResult;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Dealer implements CardReceiver, CardMatcher {

    private static final int SCORE_FOR_RECEIVE = 17;

    private Hand hand;

    public static Dealer create() {
        return of(Hand.ready());
    }

    public static Dealer of(Hand hand) {
        return new Dealer(hand);
    }

    @Override
    public void ready() {
        hand = Hand.ready();
    }

    @Override
    public void receive(Card card) {
        if (canNotReceive()) {
            throw new IllegalStateException("더 이상 카드를 받을 수 없습니다.");
        }
        hand = hand.add(card);
    }

    @Override
    public boolean isGameOver() {
        return hand.isGameOver();
    }

    private boolean canNotReceive() {
        return hand.isSameScore(SCORE_FOR_RECEIVE) || hand.isLargerThan(SCORE_FOR_RECEIVE);
    }

    @Override
    public boolean win(Hand other) {
        if (other.isBust()) {
            return true;
        }
        if (hand.isBust()) {
            return false;
        }
        return hand.isLargerThan(other);
    }

    public WinningResult win2(Hand other) {
        if (other.isBust()) {
            return new Win(hand);
        }
        if (hand.isBust()) {
            return new Lose();
        }
        return (hand.isLargerThan(other))? new Win(hand):new Lose();
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
