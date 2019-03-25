package dev.hongsii.blackjack.model.result;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoseTest {

    @Test
    public void getWinningMoney() {
        // given
        Lose lose = Lose.of(1000);

        // when
        int winningMoney = lose.getWinningMoney();

        // then
        assertThat(winningMoney).isEqualTo(0);
    }
}