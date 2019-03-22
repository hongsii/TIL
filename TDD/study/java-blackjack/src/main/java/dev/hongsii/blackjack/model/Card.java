package dev.hongsii.blackjack.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getScore() {
        return rank.getScore();
    }

    public enum Suit {

        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    @Getter
    public enum Rank {

        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10);

        private int score;

        Rank(int score) {
            this.score = score;
        }
    }
}
