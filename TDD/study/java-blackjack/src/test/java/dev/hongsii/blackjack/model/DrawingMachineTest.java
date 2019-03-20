package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawingMachineTest {

    @Test
    public void drawByCount() {
        // given
        Deck deck = DeckTest.createDeck(asList(
                new Card(Suit.SPADES, Rank.TWO),
                new Card(Suit.SPADES, Rank.THREE),
                new Card(Suit.SPADES, Rank.FOUR)
        ));
        DrawingMachine drawingMachine = new DrawingMachine(deck);
        Player player = Player.create();

        // when
        int drawCount = 2;
        drawingMachine.draw(drawCount, player);

        // then
        assertThat(player.getCards()).hasSize(drawCount);
    }
}