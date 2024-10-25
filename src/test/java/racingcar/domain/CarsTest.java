package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름을 (,)를 기준으로 입력하면 Cars 객체 생성에 성공한다.")
    void SuccessfullyCreateCars() {
        //given
        List<String> splitCarNames = List.of("song", "park", "kim", "Lee");

        //when then
        assertDoesNotThrow(() -> new Cars(splitCarNames));
    }

}