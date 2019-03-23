package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Cards;

import java.util.Collections;

public class Ready extends Hand {

    private Ready() {
        super(Cards.of(Collections.emptyList()));
    }

    public static Ready getInstance() {
        return SingleTon.instance;
    }

    @Override
    public Hand add(Card card) {
        Cards newCards = Cards.initialize();
        newCards.add(card);
        return Normal.of(newCards);
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public boolean isBlackjack() {
        return false;
    }

    @Override
    public boolean isBust() {
        return false;
    }

    @Override
    public int getWinningMoney(int money) {
        throw new IllegalStateException("게임이 시작되지 않았습니다.");
    }

    @Override
    public double getWinningMoneyRate() {
        return 0;
    }

    private static class SingleTon {

        private static Ready instance = new Ready();
    }
}

