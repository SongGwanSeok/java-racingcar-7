package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TryRoundTest {

    @Nested
    @DisplayName("TryRound 객체를 생성할 때")
    class whenCreateName {

        @Nested
        @DisplayName("0-9 사이의 숫자로 구성된 문자인 경우")
        class whenPositiveNumber {

            @ParameterizedTest
            @CsvSource({"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"})
            @DisplayName("성공적으로 생성한다.")
            void successfullyCreateName(String input) {
                //when then
                assertDoesNotThrow(() -> new TryRound(input));
            }

            @Test
            @DisplayName("양수의 범위를 넘어가는 경우 예외가 발생한다.")
            void throwsExceptionWhenOverInteger() {
                //given
                String input = "9999999999";

                //when then
                assertThatThrownBy(() -> new TryRound(input))
                        .isInstanceOf(IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("0-9 사이의 숫자가 아닌 문자가 포함된 경우")
        class whenContainNonNumber {
            @Test
            @DisplayName("예외를 발생한다.")
            void throwsExceptionWhenContainNonNumber() {
                //given
                String input = "-123";
                //when then
                assertThatThrownBy(() -> new TryRound(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수만 입력해야 합니다.");
            }
        }
    }
}
