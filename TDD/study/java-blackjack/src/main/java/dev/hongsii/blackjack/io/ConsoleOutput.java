package dev.hongsii.blackjack.io;

import dev.hongsii.blackjack.model.Card;
import dev.hongsii.blackjack.model.Dealer;
import dev.hongsii.blackjack.model.Player;

import java.util.List;
import java.util.StringJoiner;

import static java.util.Arrays.asList;

public class ConsoleOutput {

    public static void displayHandOfDealerOnlyOneCard(Dealer dealer) {
        printWithNewline("");
        Card firstCard = dealer.getCards().stream().findFirst().get();
        displayHand("딜러", asList(firstCard), firstCard.getScore());
    }

    public static void displayHandOfDealer(Dealer dealer) {
        printWithNewline("");
        displayHand("딜러", dealer.getCards(), dealer.getTotalScore());
    }

    public static void displayHandOfPlayer(Player player) {
        displayHand("플레이어", player.getCards(), player.getTotalScore());
    }

    private static void displayHand(String name, List<Card> cards, int totalScore) {
        printWithNewline(String.format("== %s의 패 ==", name));
        StringJoiner printingCards = new StringJoiner(" / ");
        for (Card card : cards) {
            printingCards.add(card.toString());
        }
        printWithNewline(printingCards.toString() + " (" + totalScore + ")");
    }

    public static void displayResult(boolean isWin) {
        if (isWin) {
            printWithNewline("플레이어가 이겼습니다.");
        } else {
            printWithNewline("딜러가 이겼습니다.");
        }
        printWithNewline("");
    }

    public static void printInvalidInput() {
        printWithNewline("잘못된 입력입니다.");
    }

    public static void printWithNewline(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }
}
