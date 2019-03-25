package dev.hongsii.blackjack.model.result;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PushTest {

    @Test
    public void getWinningMoney() {
        // given
        int bettingMoney = 1000;
        Push push = Push.of(bettingMoney);

        // when
        int winningMoney = push.getWinningMoney();

        // then
        assertThat(winningMoney).isEqualTo(bettingMoney);
    }
}