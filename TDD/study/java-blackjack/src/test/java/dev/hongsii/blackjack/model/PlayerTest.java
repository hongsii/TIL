package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void receive() {
        // given
        Hand handOfSixteen = Hand.of(asList(
                new Card(Suit.DIAMONDS, Rank.TEN),
                new Card(Suit.SPADES, Rank.SIX)
        ));
        Player player = Player.of(handOfSixteen);

        // when
        player.receive(new Card(Suit.DIAMONDS, Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(3);
    }
}