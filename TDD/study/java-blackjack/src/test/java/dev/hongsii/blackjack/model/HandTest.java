package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import dev.hongsii.blackjack.model.status.Blackjack;
import dev.hongsii.blackjack.model.status.HandStatus;
import dev.hongsii.blackjack.model.status.Ready;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    @Test
    public void addCard() {
        // given
        Hand hand = Hand.initialize();

        // when
        hand.add(new Card(Suit.CLUBS, Rank.EIGHT));

        // then
        assertThat(hand.getTotalScore()).isEqualTo(8);
    }

    @Test
    public void clear() {
        // given
        Hand hand = Hand.of(asList(
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.NINE)
        ));

        // when
        hand.clear();

        // then
        assertThat(hand.getCards()).hasSize(0);
    }

    @Test
    public void getStatusReady() {
        Hand hand = Hand.initialize();

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Ready.class);
    }

    @Test
    public void getStatusReady() {
        Hand hand = Hand.initialize();

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Ready.class);
    }

    @Test
    public void getStatusBlackjack() {
        Hand hand = Hand.of(asList(
                new Card(Suit.CLUBS, Rank.TEN),
                new Card(Suit.CLUBS, Rank.FIVE),
                new Card(Suit.CLUBS, Rank.SIX)
        ));

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Blackjack.class);
    }

    @Test
    public void getTotalScore() {
        // given
        Hand hand = Hand.of(asList(
                new Card(Suit.CLUBS, Rank.EIGHT),
                new Card(Suit.CLUBS, Rank.NINE)
        ));

        // when
        int totalScore = hand.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(17);
    }
}