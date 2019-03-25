package dev.hongsii.blackjack.model.result;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PushTest {

    @Test
    public void getWinningMoney() {
        // given
        Push push = Push.getInstance();

        // when
        int bettingMoney = 1000;
        int winningMoney = push.getWinningMoney(bettingMoney);

        // then
        assertThat(winningMoney).isEqualTo(bettingMoney);
    }
}