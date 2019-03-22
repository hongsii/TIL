package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Bust;
import dev.hongsii.blackjack.model.hand.Normal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    public void receiveCardWhenTotalScoreLessThanScoreForReceive() {
        // given
        Normal handOfSixteen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SIX)));
        Dealer dealer = Dealer.of(handOfSixteen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.TWO));

        // then
        assertThat(dealer.getCards()).hasSize(3);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotReceiveCardWhenTotalScoreMoreThanScoreForReceive() {
        // given
        Normal cardsOfSeventeen = Normal.of(CardsTest.createCards(CardTest.ofDiamonds(Card.Rank.TEN), CardTest.ofSpades(Card.Rank.SEVEN)));
        Dealer dealer = Dealer.of(cardsOfSeventeen);

        // when
        dealer.receive(CardTest.ofDiamonds(Card.Rank.TWO));
    }

    @Test
    public void win() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // when
        boolean isWin = dealer.win(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        assertThat(isWin).isTrue();
    }

    @Test
    public void loseWhenTargetIsLarger() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.NINE))));

        // when
        boolean isWin = dealer.win(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        assertThat(isWin).isFalse();
    }

    @Test
    public void winWhenTargetIsBust() {
        // given
        Dealer dealer = Dealer.of(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        // when
        boolean isWin = dealer.win(Bust.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN))));

        assertThat(isWin).isTrue();
    }

    @Test
    public void loseWhenDealerIsBust() {
        // given
        Dealer dealer = Dealer.of(Bust.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN), CardTest.ofClubs(Card.Rank.TEN))));

        // when
        boolean isWin = dealer.win(Normal.of(CardsTest.createCards(CardTest.ofClubs(Card.Rank.TEN))));

        assertThat(isWin).isFalse();
    }
}