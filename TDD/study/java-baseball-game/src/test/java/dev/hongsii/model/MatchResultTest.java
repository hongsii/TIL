package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {

    @Test
    public void record() {
        MatchResult matchResult = MatchResult.init();

        matchResult.record(true, true);

        assertThat(matchResult.getResultTypes()).hasSize(1).containsOnly(ResultType.STRIKE);
    }
}