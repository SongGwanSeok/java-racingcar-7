package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarNamesSplitterTest {

    @Test
    @DisplayName("정상적인 입력인 경우 split 성공 테스트")
    void SuccessfullySplitTest() {
        //given
        CarNamesSplitter carNamesSplitter = new CarNamesSplitter();
        String invalidCarNames = "song,park,kim,Lee";
        List<String> expected = List.of("song", "park", "kim", "Lee");

        //when
        List<String> actual = carNamesSplitter.split(invalidCarNames);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Nested
    @DisplayName("정상적인 입력인 아닌 경우 예외 테스트")
    class WhenThrowsExceptionTest {

        @Test
        @DisplayName("2개 이하의 자동차 이름이 입력된 경우")
        void throwsExceptionWhenCarNamesLengthLess2() {
            //given
            CarNamesSplitter carNamesSplitter = new CarNamesSplitter();
            String invalidCarNames = "song";

            //when then
            assertThatThrownBy(() -> carNamesSplitter.split(invalidCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("경주를 하기 위해서는 두대 이상의 자동차가 필요합니다.");
        }

        @Test
        @DisplayName("중복된 이름이 포함된 입력이 들어오는 경우 예외를 반환한다.")
        void throwsExceptionWhenDuplicateCarNames() {
            //given
            CarNamesSplitter carNamesSplitter = new CarNamesSplitter();
            String invalidCarNames = "song,park,kim,song";

            //when then
            assertThatThrownBy(() -> carNamesSplitter.split(invalidCarNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 이름은 사용할 수 없습니다.");
        }
    }
}