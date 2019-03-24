package dev.hongsii.blackjack.model.result;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoseTest {

    @Test
    public void getWinningMoney() {
        // given
        Lose lose = new Lose();

        // when
        int bettingMoney = 1000;
        int winningMoney = lose.getWinningMoney(bettingMoney);

        // then
        assertThat(winningMoney).isEqualTo(-bettingMoney);
    }
}