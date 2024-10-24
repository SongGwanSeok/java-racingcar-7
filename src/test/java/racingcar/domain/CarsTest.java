package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 이름을 (,)를 기준으로 입력하면 Cars 객체 생성에 성공한다.")
    void SuccessfullyCreateCars() {
        //given
        String input = "song,park,kim,Lee";

        //when then
        assertDoesNotThrow(() -> new Cars(input));
    }

    @Test
    @DisplayName("자동차 이름이 2개이상 들어오지 않은 경우 예외가 발생한다.")
    void throwsExceptionWhenCarNamesLessThan2() {
        //given
        String input = "song";

        //when then
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
    }

    @Test
    @DisplayName("중복된 자동차 이름이 들어오는 경우 예외가 발생한다.")
    void throwsExceptionWhenCarNamesIsDuplicated() {
        //given
        String input = "song,song";

        //when then
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 사용할 수 없습니다.");
    }

}