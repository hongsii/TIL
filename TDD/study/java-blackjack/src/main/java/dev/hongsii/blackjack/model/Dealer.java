package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Dealer implements CardReceiver {

    private static final int SCORE_FOR_RECEIVE = 17;

    private Hand hand;

    public static Dealer create() {
        return of(Hand.initialize());
    }

    public static Dealer of(Hand hands) {
        return new Dealer(hands);
    }

    @Override
    public void receive(Card card) {
        if (canNotReceive()) {
            throw new IllegalStateException("더 이상 카드를 받을 수 없습니다.");
        }
        hand.add(card);
    }

    private boolean canNotReceive() {
        return hand.getTotalScore() >= SCORE_FOR_RECEIVE;
    }

    public List<Card> getCards() {
        return hand.getCards();
    }
}
