package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;
import dev.hongsii.blackjack.model.hand.Ready;
import dev.hongsii.blackjack.model.result.Lose;
import dev.hongsii.blackjack.model.result.Push;
import dev.hongsii.blackjack.model.result.Result;
import dev.hongsii.blackjack.model.result.Win;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Dealer implements CardReceiver, CardMatcher {

    private static final int SCORE_FOR_RECEIVE = 17;

    private Hand hand;

    public static Dealer create() {
        return of(Ready.noBetting());
    }

    public static Dealer of(Hand hand) {
        return new Dealer(hand);
    }

    public void reset() {
        hand = Ready.noBetting();
    }

    @Override
    public void receive(Card card) {
        if (!canReceive()) {
            throw new IllegalStateException("더 이상 카드를 받을 수 없습니다.");
        }
        hand = hand.add(card);
    }

    @Override
    public boolean canReceive() {
        return isLessThanScoreForReceive();
    }

    private boolean isLessThanScoreForReceive() {
        return hand.getTotalScore() < SCORE_FOR_RECEIVE;
    }

    @Override
    public Result match(Hand target) {
        if (target.isBust()) {
            return Lose.from(target);
        }
        if (hand.isBust()) {
            return Win.from(target);
        }
        if (target.isSameScore(hand)) {
            return Push.from(target);
        }
        return (target.isLargerScore(hand)) ? Win.from(target) : Lose.from(target);
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getTotalScore() {
        return hand.getTotalScore();
    }
}
