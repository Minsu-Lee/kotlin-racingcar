package racing.controller

import racing.model.car.Car
import racing.model.generator.NumberGenerator
import racing.view.input.InputView
import racing.view.result.ResultView

internal class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val numberGenerator: racing.model.generator.NumberGenerator,
) : RacingController {
    override fun start() {
        val carCount = inputView.promptAndValidateCarCountInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()
        println()

        val cars = getCarList(carCount)

        resultView.printOutputTitle()
        repeat(attemptCount) {
            startRound(cars)
            resultView.displayCarMovement(cars)
        }
    }

    private fun getCarList(carCount: Int): List<racing.model.car.Car> {
        return List(carCount) {
            racing.model.car.Car(
                forwardLimit = racing.model.car.Car.DEFAULT_FORWARD_LIMIT,
                numberGenerator = numberGenerator,
            )
        }
    }

    private fun startRound(cars: List<racing.model.car.Car>) {
        fun move(car: racing.model.car.Car) = car.move()
        cars.forEach(::move)
    }
}
