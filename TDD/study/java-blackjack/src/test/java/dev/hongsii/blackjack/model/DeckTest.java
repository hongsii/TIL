package dev.hongsii.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = Deck.initialize();
    }

    @Test
    public void hasDefaultSizeAndWhenInit() {
        // when
        int deckSize = deck.size();

        // then
        assertThat(deckSize).isEqualTo(Deck.DEFAULT_SIZE);
    }

    @Test
    public void draw() {
        // when
        deck.draw();

        // then
        assertThat(deck.size()).isEqualTo(Deck.DEFAULT_SIZE - 1);
    }

    @Test(expected = IllegalStateException.class)
    public void cannotDrawWhenEmpty() {
        // given
        for (int i = 0; i < Deck.DEFAULT_SIZE; i++) {
            deck.draw();
        }

        // when
        deck.draw();
    }

    public static Deck createDeck(List<Card> cards) {
        return Deck.of(cards.stream().collect(Collectors.toCollection(Stack::new)));
    }
}