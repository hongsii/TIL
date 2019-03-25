package dev.hongsii.blackjack.model.result;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.CardTest;
import dev.hongsii.blackjack.model.CardsTest;
import dev.hongsii.blackjack.model.hand.Blackjack;
import dev.hongsii.blackjack.model.hand.Normal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTest {

    @Test
    public void getWinningMoneyWhenHandIsNormal() {
        // given
        int bettingMoney = 1000;
        Win win = Win.from(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.FOUR)), bettingMoney));

        // when
        int winningMoney = win.getWinningMoney();

        // then
        assertThat(winningMoney).isEqualTo(2000);
    }

    @Test
    public void getWinningMoneyWhenHandIsBlackjack() {
        // given
        int bettingMoney = 1000;
        Win win = Win.from(Blackjack.of(CardsTest.BLACKJACK, bettingMoney));

        // when
        int winningMoney = win.getWinningMoney();

        // then
        assertThat(winningMoney).isEqualTo(2500);
    }
}