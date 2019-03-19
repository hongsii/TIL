package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void draw() {
        // given
        Player player = Player.create();
        Deck deck = DeckTest.createDeck(asList(
                new Card(Suit.DIAMONDS, Rank.FOUR),
                new Card(Suit.DIAMONDS, Rank.FIVE)
        ));

        // when
        player.draw(deck);

        // then
        assertThat(player.getCards()).hasSize(Player.DEFAULT_DRAW_COUNT);
    }
}