package dev.hongsii.blackjack.model;

public interface CardReceiver {

    void ready();
    void receive(Card card);
    boolean isBlackjack();
    boolean isBust();
}
