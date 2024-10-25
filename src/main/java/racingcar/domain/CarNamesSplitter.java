package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNamesSplitter {

    public List<String> split(String invalidCarNames) {
        List<String> splitCarNames = Arrays.stream(invalidCarNames.split(",")).toList();
        validateCarNames(splitCarNames);

        return splitCarNames;
    }

    private void validateCarNames(List<String> splitCarNames) {
        if (splitCarNames.size() < 2) {
            throw new IllegalArgumentException("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
        }

        if (splitCarNames.stream().distinct().count() != splitCarNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
