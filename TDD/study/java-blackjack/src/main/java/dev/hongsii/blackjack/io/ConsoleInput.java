package dev.hongsii.blackjack.io;

import dev.hongsii.blackjack.model.Player;

import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBettingMoney(Player player) {
        while (true) {
            ConsoleOutput.print("배팅할 금액 " + "(보유 금액 : " + player.getMoney() + ")" + " : ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                ConsoleOutput.printInvalidInput();
                scanner.nextLine();
            }
        }
    }

    public static boolean inputPlayerInputForHit() {
        while (true) {
            ConsoleOutput.print("\n히트하시겠습니까? (y/n) : ");
            String input = scanner.next();
            if ("y".equals(input.toLowerCase())) {
                return true;
            }
            if ("n".equals(input.toLowerCase())) {
                return false;
            }
            ConsoleOutput.printInvalidInput();
        }
    }
}
