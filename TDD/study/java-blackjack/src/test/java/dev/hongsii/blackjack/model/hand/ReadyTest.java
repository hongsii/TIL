package dev.hongsii.blackjack.model.hand;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.Cards;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadyTest {

    private Ready ready;

    @Before
    public void setUp() throws Exception {
        ready = Ready.getInstance();
    }

    @Test
    public void readyIsSingleton() {
        assertThat(ready == Ready.getInstance()).isTrue();
    }

    @Test
    public void nextToTotal() {
        // given
        Card card = CardTest.ofHearts(Card.Rank.NINE);

        // when
        Hand next = ready.add(card);

        // then
        assertThat(next).isEqualTo(Normal.of(Cards.of(asList(card))));
    }
}
