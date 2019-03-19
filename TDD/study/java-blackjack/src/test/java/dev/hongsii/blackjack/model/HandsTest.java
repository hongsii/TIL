package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HandsTest {

    @Test
    public void getTotalScore() {
        // given
        Hands hands = Hands.of(asList(
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.NINE)
        ));

        // when
        int totalScore = hands.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(17);
    }

    @Test
    public void addCard() {
        // given
        Hands hands = Hands.initialize();

        // when
        hands.addCard(new Card(Suit.CLUBS, Rank.EIGHT));

        // then
        assertThat(hands.getTotalScore()).isEqualTo(8);
    }
}