package racing

import racing.model.Car
import racing.model.CarFactory
import racing.model.IntRangeEngine
import racing.model.EngineFactory
import racing.model.WinnerDecider
import racing.view.input.InputView
import racing.view.result.ResultView

class GameContext(
    val inputView: InputView,
    val resultView: ResultView,
) {
    fun createCars(
        carNames: List<String>,
        range: IntRange = IntRangeEngine.DEFAULT_RANDOM_RANGE,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT,
    ): List<Car> {
        return CarFactory.createCars(carNames) {
            EngineFactory.create(range, forwardLimit)
        }
    }

    fun getRaceWinners(cars: List<Car>): List<Car> {
        return WinnerDecider.decideWinners(cars)
    }
}
