package dev.hongsii.blackjack.model.status;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackTest {

    private Blackjack blackjack;

    @Before
    public void setUp() throws Exception {
        blackjack = Blackjack.getInstance();
    }

    @Test
    public void blackjackIsSingleton() {
        assertThat(blackjack == Blackjack.getInstance()).isTrue();
    }

    @Test
    public void isBlackjack() {
        assertThat(Blackjack.is(Blackjack.SCORE)).isTrue();
    }

    @Test
    public void isNotBlackjack() {
        assertThat(Blackjack.is(Blackjack.SCORE + 1)).isFalse();
        assertThat(Blackjack.is(Blackjack.SCORE - 1)).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotNext() {
        blackjack.next(2);
    }
}