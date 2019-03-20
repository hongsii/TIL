package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.status.HandStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Hand {

    private List<Card> cards;

    public static Hand initialize() {
        return of(Collections.emptyList());
    }

    public static Hand of(List<Card> cards) {
        return new Hand(new ArrayList<>(cards));
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public HandStatus getStatus() {
        return HandStatus.of(getTotalScore());
    }

    public int getTotalScore() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
