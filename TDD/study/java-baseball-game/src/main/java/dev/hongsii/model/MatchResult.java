package dev.hongsii.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchResult {

    private List<ResultType> resultTypes;

    private MatchResult(List<ResultType> resultTypes) {
        this.resultTypes = resultTypes;
    }

    public static MatchResult init() {
        return of(new ArrayList<>());
    }

    public static MatchResult of(List<ResultType> resultTypes) {
        return new MatchResult(resultTypes);
    }

    public void record(boolean isCorrectDigit, boolean isCorrectPosition) {
        resultTypes.add(ResultType.of(isCorrectDigit, isCorrectPosition));
    }

    public List<ResultType> getResultTypes() {
        return Collections.unmodifiableList(resultTypes);
    }
}
