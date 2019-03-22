package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Normal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void receive() {
        // given
        Normal handOfSixteen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SIX)));
        Player player = Player.of(handOfSixteen);

        // when
        player.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(player.getCards()).hasSize(3);
    }

    @Test
    public void win() {
        // given
        Player player = Player.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        boolean isWin = player.winTo(dealer);

        // then
        assertThat(isWin).isTrue();
    }

    @Test
    public void winWhenDealerIsBust() {
        // given
        Player player = Player.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        boolean isWin = player.winTo(dealer);

        // then
        assertThat(isWin).isTrue();
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