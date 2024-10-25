package racingcar.domain;

public class RacingGame {

    private final Cars cars;

    public RacingGame(String invalidCarNames) {
        CarNamesSplitter carNamesSplitter = new CarNamesSplitter();
        cars = new Cars(carNamesSplitter.split(invalidCarNames));
    }

    public String proceedRound() {
        cars.moveAll();

        return cars.getCurrentRoundResult();
    }

    public String findWinner() {
        return cars.findWinnerCarNames();
    }
}
