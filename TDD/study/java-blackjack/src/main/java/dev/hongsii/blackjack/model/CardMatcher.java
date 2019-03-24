package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Hand;

public interface CardMatcher {

    boolean win(Hand hand);
    WinningResult win2(Hand other) {
}
