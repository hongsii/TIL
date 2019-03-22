package dev.hongsii.blackjack.io;

import java.util.Scanner;

public class ConsoleInput {

    private static final Scanner scanner = new Scanner(System.in);

//    public static int inputBettingMoney(Player player) {
//        System.out.println("플레이어가 소유한 금액 : " + player.getMoney());
//        System.out.printf("-> 배팅 : ");
//        return scanner.nextInt();
//    }

    public static boolean inputPlayerInputForHit() {
        while (true) {
            System.out.print("히트하시겠습니까? (y/n) : ");
            String input = scanner.next();
            if ("y".equals(input.toLowerCase())) {
                return true;
            }
            if ("n".equals(input.toLowerCase())) {
                return false;
            }
            System.out.println("잘못된 입력입니다.");
        }
    }
}
