package dev.hongsii.model;

import java.util.Arrays;

public enum ResultType {

    STRIKE(true, true),
    BALL(true, false),
    OUT(false, false);

    private boolean isCorrectDigit;
    private boolean isCorrectPosition;

    ResultType(boolean isCorrectDigit, boolean isCorrectPosition) {
        this.isCorrectDigit = isCorrectDigit;
        this.isCorrectPosition = isCorrectPosition;
    }

    public static ResultType of(boolean isCorrectDigit, boolean isCorrectPosition) {
        return Arrays.stream(values())
                .filter(resultType -> resultType.isSameResult(isCorrectDigit, isCorrectPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 결과가 없습니다."));
    }

    private boolean isSameResult(boolean isCorrectDigit, boolean isCorrectPosition) {
        return (this.isCorrectDigit == isCorrectDigit)
                && (this.isCorrectPosition == isCorrectPosition);
    }
}
