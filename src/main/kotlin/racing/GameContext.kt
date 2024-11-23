package racing

import racing.model.Car
import racing.model.CarFactory
import racing.model.Engine
import racing.model.EngineFactory
import racing.view.input.InputView
import racing.view.result.ResultView

class GameContext(
    val inputView: InputView,
    val resultView: ResultView,
    private val carFactory: CarFactory,
    private val engineFactory: EngineFactory,
) {
    constructor(inputView: InputView, resultView: ResultView) : this(
        inputView = inputView,
        resultView = resultView,
        carFactory = CarFactory,
        engineFactory = EngineFactory,
    )

    fun createCars(
        carNames: List<String>,
        range: IntRange = Engine.DEFAULT_RANDOM_RANGE,
    ): List<Car> {
        return carFactory.createCars(carNames) {
            engineFactory.create(range)
        }
    }
}
