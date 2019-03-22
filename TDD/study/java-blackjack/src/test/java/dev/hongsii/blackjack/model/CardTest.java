package dev.hongsii.blackjack.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    public void equals() {
        assertThat(new Card(Card.Suit.CLUBS, Card.Rank.ACE)).isEqualTo(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
    }
}