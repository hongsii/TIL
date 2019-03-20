package dev.hongsii.blackjack.model.status;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTotalIsMoreThanBlackjackScore() {
        Total.of(Blackjack.SCORE);
    }

    @Test
    public void canCaching() {
        assertThat(Total.of(10) == Total.of(10)).isTrue();
    }

    @Test
    public void nextToTotal() {
        // given
        Total ten = Total.of(10);

        // when
        HandStatus next = ten.next(5);

        // then
        assertThat(next).isEqualTo(Total.of(15));
    }

    @Test
    public void nextToBlackjack() {
        // given
        Total ten = Total.of(10);

        // when
        HandStatus next = ten.next(11);

        // then
        assertThat(next).isInstanceOf(Blackjack.class);
    }

    @Test
    public void nextToBust() {
        // given
        Total twelve = Total.of(20);

        // when
        HandStatus next = twelve.next(2);

        // then
        assertThat(next).isInstanceOf(Bust.class);
    }
}