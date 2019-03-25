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
        Win win = Win.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.FOUR))));

        // when
        int bettingMoney = 1000;
        int winningMoney = win.getWinningMoney(bettingMoney);

        // then
        assertThat(winningMoney).isEqualTo(2000);
    }

    @Test
    public void getWinningMoneyWhenHandIsBlackjack() {
        // given
        Blackjack blackjack = Blackjack.of(CardsTest.BLACKJACK);
        Win win = Win.of(blackjack);

        // when
        int bettingMoney = 1000;
        int winningMoney = win.getWinningMoney(bettingMoney);

        // then
        assertThat(winningMoney).isEqualTo(2500);
    }
}