package racing.controller

import racing.model.car.Car
import racing.model.generator.NumberGenerator
import racing.view.input.InputView
import racing.view.result.ResultView

internal class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val numberGenerator: NumberGenerator,
) : RacingController {
    override fun start() {
        val carCount = inputView.promptAndValidateCarCountInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()
        inputView.handleNewLine()

        val cars = getCarList(carCount)

        resultView.printOutputTitle()
        repeat(attemptCount) {
            startRound(cars)
            resultView.displayCarMovement(cars)
        }
    }

    private fun getCarList(carCount: Int): List<Car> {
        return List(carCount) {
            Car(
                forwardLimit = Car.DEFAULT_FORWARD_LIMIT,
                numberGenerator = numberGenerator,
            )
        }
    }

    private fun startRound(cars: List<Car>) {
        fun move(car: Car) = car.move()
        cars.forEach(::move)
    }
}
