package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Deck {

    public static final int DEFAULT_SIZE = 52;

    private Stack<Card> deck;

    public static Deck initialize() {
        Stack<Card> newDeck = createCards();
        Collections.shuffle(newDeck);
        return of(newDeck);
    }

    public static Deck of(Stack<Card> deck) {
        return new Deck(deck);
    }

    private static Stack<Card> createCards() {
        return Arrays.stream(Suit.values())
                    .flatMap(suit -> Arrays.stream(Rank.values()).map(rank -> new Card(suit, rank)))
                    .collect(Collectors.toCollection(Stack::new));
    }

    public Card draw() {
        if (size() == 0) {
            throw new IllegalStateException("카드가 존재하지 않습니다.");
        }
        return deck.pop();
    }

    public int size() {
        return deck.size();
    }
}
