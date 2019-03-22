package dev.hongsii.blackjack.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void receive() {
        // given
        Hand handOfSixteen = Hand.of(asList(
                new Card(Card.Suit.DIAMONDS, Card.Rank.TEN),
                new Card(Card.Suit.SPADES, Card.Rank.SIX)
        ));
        Player player = Player.of(handOfSixteen);

        // when
        player.receive(new Card(Card.Suit.DIAMONDS, Card.Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(3);
    }
}