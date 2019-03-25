package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Bust;
import dev.hongsii.blackjack.model.hand.Normal;
import dev.hongsii.blackjack.model.result.Result;
import dev.hongsii.blackjack.model.result.Win;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = Player.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));
    }

    @Test
    public void receive() {
        // when
        player.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(2);
    }

    @Test
    public void win() {
        // given
        int bettingMoney = Player.DEFAULT_MONEY;
        player.bet(bettingMoney);
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        Result result = player.winTo(dealer);

        // then
        assertThat(result).isEqualTo(Win.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)))));
        assertThat(player.getMoney()).isEqualTo(result.getWinningMoney(bettingMoney));
    }

    @Test
    public void winWhenDealerIsBust() {
        // given
        int bettingMoney = Player.DEFAULT_MONEY;
        player.bet(bettingMoney);
        Dealer dealer = Dealer.of(Bust.of(CardsTest.BUST));

        // when
        Result result = player.winTo(dealer);

        // then
        assertThat(result).isEqualTo(Win.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN)))));
        assertThat(player.getMoney()).isEqualTo(result.getWinningMoney(bettingMoney));
    }

    @Test
    public void bet() {
        // given
        Player player = Player.create();

        // when
        player.bet(Player.DEFAULT_MONEY);

        // then
        assertThat(player.getMoney()).isEqualTo(0);
    }
}