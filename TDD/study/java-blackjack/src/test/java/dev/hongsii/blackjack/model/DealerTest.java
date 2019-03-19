package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.enums.Rank;
import dev.hongsii.blackjack.model.enums.Suit;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    private Dealer dealer;

    @Before
    public void setUp() throws Exception {
        dealer = Dealer.create();
    }

    @Test
    public void drawWhenTotalScoreMoreThen17() {
        // given
        Deck deck = DeckTest.createDeck(asList(
                new Card(Suit.DIAMONDS, Rank.SEVEN),
                new Card(Suit.SPADES, Rank.TEN)
        ));

        // when
        dealer.draw(deck);

        // then
        assertThat(dealer.getCards()).hasSize(Dealer.DEFAULT_DRAW_COUNT);
    }

    @Test
    public void drawOneMoreWhenTotalScoreLessThan17() {
        // given
        Deck deck = DeckTest.createDeck(asList(
                new Card(Suit.DIAMONDS, Rank.SIX),
                new Card(Suit.SPADES, Rank.SEVEN),
                new Card(Suit.SPADES, Rank.NINE)
        ));

        // when
        dealer.draw(deck);

        // then
        assertThat(dealer.getCards()).hasSize(Dealer.DEFAULT_DRAW_COUNT + 1);
    }
}