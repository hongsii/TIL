package dev.hongsii.blackjack.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Cards {

    private List<Card> cards;

    public static Cards initialize() {
        return of(Collections.emptyList());
    }

    public static Cards of(List<Card> cards) {
        return new Cards(new ArrayList<>(cards));
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public int getTotalScore() {
        int totalScore = 0;
        List<Card> notSpecialScoreCards = cards.stream().filter(Card::hasNotSpecialScore).collect(Collectors.toList());
        totalScore = sum(totalScore, notSpecialScoreCards);
        List<Card> specialScoreCards = cards.stream().filter(Card::hasSpecialScore).collect(Collectors.toList());
        totalScore = sum(totalScore, specialScoreCards);
        return totalScore;
    }

    private int sum(int totalScore, List<Card> cards) {
        for (Card card : cards) {
            totalScore = card.sum(totalScore);
        }
        return totalScore;
    }

    public boolean isSameScore(int score) {
        return getTotalScore() == score;
    }

    public boolean isLagerThan(int score) {
        return getTotalScore() > score;
    }

    public boolean hasCountOfCards(int countOfCards) {
        return cards.size() == countOfCards;
    }

    public boolean hasCountOfCardsLargerThan(int countOfCards) {
        return cards.size() > countOfCards;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
