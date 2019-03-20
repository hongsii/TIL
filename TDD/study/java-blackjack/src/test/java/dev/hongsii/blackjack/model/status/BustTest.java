package dev.hongsii.blackjack.model.status;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BustTest {

    private Bust bust;

    @Before
    public void setUp() throws Exception {
        bust = Bust.getInstance();
    }

    @Test
    public void bustIsSingleton() {
        assertThat(bust == Bust.getInstance()).isTrue();
    }

    @Test
    public void isBust() {
        assertThat(Bust.is(Blackjack.SCORE + 1)).isTrue();
        assertThat(Bust.is(Blackjack.SCORE + 2)).isTrue();
    }

    @Test
    public void isNotBust() {
        assertThat(Bust.is(Blackjack.SCORE)).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotNext() {
        bust.next(2);
    }
}