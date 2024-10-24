package racingcar;

import java.util.Arrays;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        new RacingGameController(new InputView(), new OutputView()).run();
    }
}
