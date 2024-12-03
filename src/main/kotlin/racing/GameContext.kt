package racing

import racing.model.*
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
    ): Cars {
        return CarFactory.createCars(carNames, range, forwardLimit)
    }
}
