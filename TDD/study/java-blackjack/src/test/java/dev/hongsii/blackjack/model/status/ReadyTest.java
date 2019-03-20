package dev.hongsii.blackjack.model.status;

import org.junit.Before;
import org.junit.Test;

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
    public void isReady() {
        assertThat(Ready.is(Ready.SCORE)).isTrue();
    }

    @Test
    public void isNotReady() {
        assertThat(Ready.is(Ready.SCORE + 1)).isFalse();
        assertThat(Ready.is(Ready.SCORE - 1)).isFalse();
    }

    @Test
    public void nextToTotal() {
        // given
        int nextScore = 2;

        // when
        HandStatus next = ready.next(nextScore);

        // then
        assertThat(next).isEqualTo(Total.of(nextScore));
    }
}
