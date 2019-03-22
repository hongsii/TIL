package dev.hongsii.blackjack.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    public void receiveCardWhenTotalScoreLessThanScoreForReceive() {
        // given
        Dealer dealer = Dealer.of(HandTest.handOfSixteen);

        // when
        dealer.receive(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));

        // then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotReceiveCardWhenTotalScoreMoreThanScoreForReceive() {
        // given
        Hand handOfSeventeen = Hand.of(asList(
                new Card(Card.Suit.DIAMONDS, Card.Rank.TEN),
                new Card(Card.Suit.SPADES, Card.Rank.SEVEN)
        ));
        Dealer dealer = Dealer.of(handOfSeventeen);

        // when
        dealer.receive(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));
    }

    @Test
    public void dealWhenPlayerWins() {
        // given
        Hand handOfSixteen = Hand.of(asList(
                new Card(Card.Suit.DIAMONDS, Card.Rank.TEN),
                new Card(Card.Suit.SPADES, Card.Rank.SIX)
        ));
        Dealer dealer = Dealer.of(handOfSixteen);
        Hand handOfSeventeen = Hand.of(asList(
                new Card(Card.Suit.DIAMONDS, Card.Rank.TEN),
                new Card(Card.Suit.SPADES, Card.Rank.SEVEN)
        ));
        Player player = Player.of(handOfSeventeen);

        // when
        boolean isWinning = dealer.deal(player);

        assertThat(isWinning).isFalse();
    }
}