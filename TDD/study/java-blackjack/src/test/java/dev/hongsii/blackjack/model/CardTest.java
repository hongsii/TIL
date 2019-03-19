package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    public void equals() {
        assertThat(new Card(Suit.CLUBS, Rank.ACE)).isEqualTo(new Card(Suit.CLUBS, Rank.ACE));
    }
}