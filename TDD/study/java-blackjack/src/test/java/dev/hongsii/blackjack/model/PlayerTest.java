package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Normal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void receive() {
        // given
        Normal handOfSixteen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SIX)));
        Player player = Player.of(handOfSixteen);

        // when
        player.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(3);
    }
}