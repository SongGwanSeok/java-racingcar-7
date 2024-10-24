package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 객체를 성공적으로 생성한다.")
    void successfullyCreateCar() {
        //given
        String carName = "song";
        //when then
        assertDoesNotThrow(() -> new Car(carName));
    }

    @Test
    @DisplayName("car.toString()을 실행하면 (poby : --) 형식으로 반환한다.")
    void successfullyCarToString() {
        //given
        String carName = "song";
        String expected = "song : \n";
        //when
        Car car = new Car(carName);
        String actual = car.toString();
        //then
        assertThat(actual).isEqualTo(expected);
    }

}