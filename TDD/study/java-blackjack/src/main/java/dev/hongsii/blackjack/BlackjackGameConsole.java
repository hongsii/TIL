package dev.hongsii.blackjack;

import dev.hongsii.blackjack.io.ConsoleInput;
import dev.hongsii.blackjack.io.ConsoleOutput;
import dev.hongsii.blackjack.model.BlackjackGame;
import dev.hongsii.blackjack.model.Player;

public class BlackjackGameConsole {

    public static void main(String[] args) {
        BlackjackGame blackjackGame = BlackjackGame.initializeWithSingleDeck();

        while (true) {
            // 플레이어가 배팅한다.
            Player player = blackjackGame.getPlayer();
            blackjackGame.bet(player, ConsoleInput.inputBettingMoney(player));

            // 카드를 두장씩 뽑는다.
            blackjackGame.deal();

            // 뽑은 카드를 보여준다.
            ConsoleOutput.displayHandOfDealer(blackjackGame.getDealer());
            ConsoleOutput.displayHandOfPlayer(blackjackGame.getPlayer());

            // 플레이어가 카드를 뽑는다.
            while (true) {
                boolean isHit = ConsoleInput.inputPlayerInputForHit();
                if (!isHit) {
                    break;
                }
                blackjackGame.hit(player);
                ConsoleOutput.displayHandOfPlayer(player);
            }
            ConsoleOutput.displayResult(blackjackGame.winToDealer(blackjackGame.getPlayer()));
            System.out.println(blackjackGame.getPlayer().getMoney());
        }
    }
}
