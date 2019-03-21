package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    public void receiveCardWhenTotalScoreLessThanScoreForReceive() {
        // given
        Dealer dealer = Dealer.of(HandTest.handOfSixteen);

        // when
        dealer.receive(new Card(Suit.DIAMONDS, Rank.TWO));

        // then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotReceiveCardWhenTotalScoreMoreThanScoreForReceive() {
        // given
        Hand handOfSeventeen = Hand.of(asList(
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.SPADES, Rank.SEVEN)
        ));
        Dealer dealer = Dealer.of(handOfSeventeen);

        // when
        dealer.receive(new Card(Suit.DIAMONDS, Rank.TWO));
    }

    @Test
    public void dealWhenPlayerWins() {
        // given
        Hand handOfSixteen = Hand.of(asList(
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.SPADES, Rank.SIX)
        ));
        Dealer dealer = Dealer.of(handOfSixteen);
        Hand handOfSeventeen = Hand.of(asList(
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.SPADES, Rank.SEVEN)
        ));
        Player player = Player.of(handOfSeventeen);

        // when
        boolean isWinning = dealer.deal(player);

        assertThat(isWinning).isFalse();
    }
}