package dev.hongsii.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {

    private List<Digit> numbers;

    public BaseballNumber(List<Digit> numbers) {
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("숫자가 중복되었습니다.");
        }

        this.numbers = numbers;
    }

    private boolean hasDuplicated(List<Digit> numbers) {
        Set<Digit> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    public MatchResult match(BaseballNumber other) {
        if (numbers.size() != other.numbers.size()) {
            throw new IllegalArgumentException("같은 개수의 숫자만 비교할 수 있습니다.");
        }

        MatchResult matchResult = MatchResult.init();
        for (int index = 0; index < numbers.size(); index++) {
            Digit digit = numbers.get(index);
            boolean isCorrectDigit = other.numbers.contains(digit);
            boolean isCorrectPosition = other.numbers.indexOf(digit) == index;
            matchResult.record(isCorrectDigit, isCorrectPosition);
        }
        return matchResult;
    }

    public List<Digit> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
