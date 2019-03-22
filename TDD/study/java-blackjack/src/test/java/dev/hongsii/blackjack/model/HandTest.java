package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.status.*;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    public static final Hand handOfSixteen = Hand.of(asList(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN), new Card(Card.Suit.SPADES, Card.Rank.SIX)));
    public static final Hand handOfSeventeen = Hand.of(asList(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN), new Card(Card.Suit.SPADES, Card.Rank.SEVEN)));
    public static final Hand handOfBlackjack = Hand.of(asList(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN), new Card(Card.Suit.SPADES, Card.Rank.SEVEN), new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR)));

    @Test
    public void addCard() {
        // given
        Hand hand = Hand.initialize();

        // when
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));

        // then
        assertThat(hand.getTotalScore()).isEqualTo(8);
    }

    @Test
    public void clear() {
        // given
        Hand hand = Hand.of(asList(
                new Card(Card.Suit.CLUBS, Card.Rank.EIGHT),
                new Card(Card.Suit.CLUBS, Card.Rank.NINE)
        ));

        // when
        hand.clear();

        // then
        assertThat(hand.getCards()).hasSize(0);
    }

    @Test
    public void getStatusAsReady() {
        Hand hand = Hand.initialize();

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Ready.class);
    }

    @Test
    public void getStatusAsTotal() {
        Hand hand = Hand.of(asList(
                new Card(Card.Suit.CLUBS, Card.Rank.TEN),
                new Card(Card.Suit.CLUBS, Card.Rank.FIVE)
        ));

        HandStatus status = hand.getStatus();

        assertThat(status).isEqualTo(Total.of(15));
    }

    @Test
    public void getStatusAsBlackjack() {
        Hand hand = Hand.of(asList(
                new Card(Card.Suit.CLUBS, Card.Rank.TEN),
                new Card(Card.Suit.CLUBS, Card.Rank.FIVE),
                new Card(Card.Suit.CLUBS, Card.Rank.SIX)
        ));

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Blackjack.class);
    }

    @Test
    public void getStatusAsBust() {
        Hand hand = Hand.of(asList(
                new Card(Card.Suit.CLUBS, Card.Rank.TEN),
                new Card(Card.Suit.CLUBS, Card.Rank.FIVE),
                new Card(Card.Suit.CLUBS, Card.Rank.SEVEN)
        ));

        HandStatus status = hand.getStatus();

        assertThat(status).isInstanceOf(Bust.class);
    }

    @Test
    public void getTotalScore() {
        // given
        Hand hand = Hand.of(asList(
                new Card(Card.Suit.CLUBS, Card.Rank.EIGHT),
                new Card(Card.Suit.CLUBS, Card.Rank.NINE)
        ));

        // when
        int totalScore = hand.getTotalScore();

        // then
        assertThat(totalScore).isEqualTo(17);
    }
}