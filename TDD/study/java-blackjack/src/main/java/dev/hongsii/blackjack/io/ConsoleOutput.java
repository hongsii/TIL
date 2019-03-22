package dev.hongsii.blackjack.io;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Dealer;
import dev.hongsii.blackjack.model.Player;

import java.util.StringJoiner;

public class ConsoleOutput {

    public static void displayHandOfDealer(Dealer dealer) {
        System.out.println("== 딜러의 패 ==");
//        System.out.println(dealer.getCards().stream().findFirst().get());

        StringJoiner cards = new StringJoiner(" / ");
        for (Card card : dealer.getCards()) {
            cards.add(card.toString());
        }
        System.out.println(cards.toString());
    }

    public static void displayHandOfPlayer(Player player) {
        System.out.println("== 플레이어의 패 ==");
        StringJoiner cards = new StringJoiner(" / ");
        for (Card card : player.getCards()) {
            cards.add(card.toString());
        }
        System.out.println(cards.toString());
    }

    public static void displayResult(boolean isWin) {
        if (isWin) {
            System.out.println("플레이어가 이겼습니다.");
        } else {
            System.out.println("딜러가 이겼습니다.");
        }
    }
}
