package racingcar.domain;

public class TryRound {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int finishRound;
    private int currentRound;

    public TryRound(String invalidTryCount) {
        validatePositiveNumber(invalidTryCount);
        this.finishRound = Integer.parseInt(invalidTryCount);
        this.currentRound = 1;
    }

    private void validatePositiveNumber(String invalidTryCount) {
        if (!invalidTryCount.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("양수만 입력해야 합니다.");
        }
    }

    public boolean isNotFinish() {
        return finishRound >= currentRound;
    }

    public void moveToNextRound() {
        currentRound++;
    }
}
