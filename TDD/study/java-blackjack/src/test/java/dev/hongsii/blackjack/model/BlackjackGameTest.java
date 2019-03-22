package dev.hongsii.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackGameTest {


    private BlackjackGame blackjackGame;

    @Before
    public void setUp() throws Exception {
        blackjackGame = BlackjackGame.initializeWithSingleDeck();
    }

    @Test
    public void drawToEachCardReceiverByDefaultDrawCount() {
        // when
        blackjackGame.deal();

        // then
        assertThat(blackjackGame.getDealer().getCards()).hasSize(BlackjackGame.DEFAULT_DRAW_COUNT);
        assertThat(blackjackGame.getPlayer().getCards()).hasSize(BlackjackGame.DEFAULT_DRAW_COUNT);
    }

    @Test
    public void receiveAdditionalCardWhenHit() {
        blackjackGame.hit(blackjackGame.getPlayer());

        assertThat(blackjackGame.getPlayer().getCards()).hasSize(BlackjackGame.ADDITIONAL_DRAW_COUNT);
    }
}