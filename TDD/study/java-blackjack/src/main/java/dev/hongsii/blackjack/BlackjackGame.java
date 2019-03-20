package dev.hongsii.blackjack;

import dev.hongsii.blackjack.model.Dealer;
import dev.hongsii.blackjack.model.DrawingMachine;
import dev.hongsii.blackjack.model.Player;

public class BlackjackGame {

    public static final int DEFAULT_DRAW_COUNT = 2;

    private DrawingMachine drawingMachine;
    private Dealer dealer;
    private Player player;

    public void bet(Player player, int money) {
        // TODO 플레이어가 배팅한다.
    }

    public void draw(Player player) {
//        player.draw(deck);
    }

    public void hit(Player player) {
//        player.drawByCount(1, deck);
    }

    public void stand(Player player) {
    }
}
