package dev.hongsii.blackjack.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackGameTest {


    private BlackjackGame blackjackGame;

    @Before
    public void setUp() throws Exception {
        blackjackGame = BlackjackGame.initializeWithSingleDeck(2);
    }

    @Test
    public void drawToEachCardReceiverByDefaultDrawCount() {
        // when
        blackjackGame.deal();

        // then
        assertThat(blackjackGame.getDealer().getCards()).hasSize(BlackjackGame.DEFAULT_DRAW_COUNT);
        for (Player player : blackjackGame.getPlayers()) {
            assertThat(player.getCards()).hasSize(BlackjackGame.DEFAULT_DRAW_COUNT);
        }
    }

    @Test
    public void receiveAdditionalCardWhenHit() {
        for (Player player : blackjackGame.getPlayers()) {
            blackjackGame.hit(player);
            assertThat(player.getCards()).hasSize(BlackjackGame.ADDITIONAL_DRAW_COUNT);
        }

    }
}