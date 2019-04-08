package dev.hongsii.blackjack;

import dev.hongsii.blackjack.io.ConsoleInput;
import dev.hongsii.blackjack.io.ConsoleOutput;
import dev.hongsii.blackjack.model.BlackjackGame;
import dev.hongsii.blackjack.model.Dealer;
import dev.hongsii.blackjack.model.Player;

public class BlackjackGameConsole {

    public static void main(String[] args) {
        int countOfPlayer = ConsoleInput.inputCountOfPlayer();
        BlackjackGame blackjackGame = BlackjackGame.initializeWithSingleDeck(countOfPlayer);

        while (true) {
            // 플레이어가 배팅한다.
            for (Player player : blackjackGame.getPlayers()) {
                blackjackGame.betOnTable(player, ConsoleInput.inputBettingMoney(player));
            }

            // 카드를 두장씩 뽑고, 게임 종료 여부 확인
            blackjackGame.deal(blackjackGame.getDealer());
            ConsoleOutput.displayHandOfDealerOnlyOneCard(blackjackGame.getDealer());
            for (Player player : blackjackGame.getPlayers()) {
                blackjackGame.deal(player);
                ConsoleOutput.displayHandOfPlayer(player);
            }

            // 추가로 카드 뽑기
            hitFromDealer(blackjackGame);
            for (Player player : blackjackGame.getPlayers()) {
                hitFromPlayer(blackjackGame, player);
            }

            // 결과를 확인한다.
            ConsoleOutput.displayHandOfDealer(blackjackGame.getDealer());
            for (Player player : blackjackGame.getPlayers()) {
                ConsoleOutput.displayHandOfPlayer(player);
                ConsoleOutput.displayResult(blackjackGame.winToDealer(player));
            }
        }
    }

    private static void hitFromPlayer(BlackjackGame blackjackGame, Player player) {
        while (player.canReceive()) {
            boolean isHit = ConsoleInput.inputPlayerInputForHit(player);
            if (!isHit) {
                break;
            }
            blackjackGame.hit(player);
            ConsoleOutput.displayHandOfPlayer(player);
        }
    }

    private static void hitFromDealer(BlackjackGame blackjackGame) {
        Dealer dealer = blackjackGame.getDealer();
        while (dealer.canReceive()) {
            blackjackGame.hit(dealer);
        }
    }

}
