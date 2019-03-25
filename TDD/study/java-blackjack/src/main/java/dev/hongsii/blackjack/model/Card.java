package dev.hongsii.blackjack.model;

import dev.hongsii.blackjack.model.hand.Blackjack;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

@EqualsAndHashCode
public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card of(Suit suit, Rank rank) {
        return new Card(suit, rank);
    }

    public int sum(int score) {
        try {
            return rank.sumBySpecialScore(score);
        } catch (IllegalStateException e) {
            return rank.sum(score);
        }
    }

    public int getScore() {
        return rank.score;
    }

    @Override
    public String toString() {
        return "[" + suit.character + "" + rank.character + "]";
    }

    public boolean hasSpecialScore() {
        return rank.hasSpecialScore();
    }

    public boolean hasNotSpecialScore() {
        return !hasSpecialScore();
    }

    /**
     * 카드 문양
     */
    @AllArgsConstructor
    public enum Suit {

        CLUBS("︎♣︎"), DIAMONDS("♦︎"), HEARTS("♥︎"), SPADES("♠︎");

        @Getter
        private String character;
    }

    /**
     * 카드 숫자
     */
    public enum Rank {

        ACE(1, 11, "A"),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10, "J"),
        QUEEN(10, "Q"),
        KING(10, "K");

        private int score;
        private Optional<Integer> specialScore;
        private String character;

        Rank(int score) {
            this(score, null, Integer.toString(score));
        }

        Rank(int score, String character) {
            this(score, null, character);
        }

        Rank(int score, Integer specialScore, String character) {
            this.score = score;
            this.specialScore = Optional.ofNullable(specialScore);
            this.character = character;
        }

        public int sum(int score) {
            return this.score + score;
        }

        public int sumBySpecialScore(int score) {
            if (!hasSpecialScore()) {
                throw new IllegalStateException("스페셜 점수를 사용할 수 없습니다.");
            }
            int totalScore = this.specialScore.get() + score;
            if (totalScore > Blackjack.SCORE) {
                throw new IllegalStateException("합이 블랙잭 점수보다 클 경우 스페셜 점수를 사용할 수 없습니다.");
            }
            return totalScore;
        }

        public boolean hasSpecialScore() {
            return specialScore.isPresent();
        }
    }
}
