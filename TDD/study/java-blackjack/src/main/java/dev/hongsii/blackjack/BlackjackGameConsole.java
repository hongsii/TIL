package dev.hongsii.blackjack;

import dev.hongsii.blackjack.exception.GameOverException;
import dev.hongsii.blackjack.io.ConsoleInput;
import dev.hongsii.blackjack.io.ConsoleOutput;
import dev.hongsii.blackjack.model.BlackjackGame;
import dev.hongsii.blackjack.model.Dealer;

public class BlackjackGameConsole {

    public static void main(String[] args) {
        BlackjackGame blackjackGame = BlackjackGame.initializeWithSingleDeck();

        while (true) {
            // 플레이어가 배팅한다.
            blackjackGame.bet(blackjackGame.getPlayer(), ConsoleInput.inputBettingMoney(blackjackGame.getPlayer()));

            try {
                // 카드를 두장씩 뽑고, 게임 종료 여부 확인
                blackjackGame.deal();
                ConsoleOutput.displayHandOfDealerOnlyOneCard(blackjackGame.getDealer());
                ConsoleOutput.displayHandOfPlayer(blackjackGame.getPlayer());

                // 추가로 카드를 뽑는다.
                hitFromPlayer(blackjackGame);
                hitFromDealer(blackjackGame);
            } catch (GameOverException e) {
                // 게임 종료
            } finally {
                // 결과를 확인한다.
                ConsoleOutput.displayHandOfDealer(blackjackGame.getDealer());
                ConsoleOutput.displayHandOfPlayer(blackjackGame.getPlayer());
                ConsoleOutput.displayResult(blackjackGame.winToDealer(blackjackGame.getPlayer()));
            }
        }
    }

    private static void hitFromPlayer(BlackjackGame blackjackGame) {
        while (true) {
            blackjackGame.validateHand(blackjackGame.getPlayer());
            boolean isHit = ConsoleInput.inputPlayerInputForHit();
            if (!isHit) {
                break;
            }
            blackjackGame.hit(blackjackGame.getPlayer());
            ConsoleOutput.displayHandOfPlayer(blackjackGame.getPlayer());
        }
    }

    private static void hitFromDealer(BlackjackGame blackjackGame) {
        Dealer dealer = blackjackGame.getDealer();
        while (dealer.canReceive()) {
            blackjackGame.hit(dealer);
        }
    }

}
