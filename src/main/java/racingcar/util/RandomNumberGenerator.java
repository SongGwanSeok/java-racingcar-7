package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
