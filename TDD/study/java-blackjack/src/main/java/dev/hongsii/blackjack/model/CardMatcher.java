package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;

public interface CardMatcher {

    boolean win(Hand hand);
}
