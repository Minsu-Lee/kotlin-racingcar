package racing.controller

import racing.model.car.Car
import racing.service.generator.NumberGenerator
import racing.view.input.InputView
import racing.view.result.ResultView

internal class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val numberGenerator: NumberGenerator,
) : RacingController {
    override fun start() {
        val carNames = inputView.promptAndValidateCarNamesInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()

        val cars = getCarList(carNames)

        resultView.printOutputTitle()
        repeat(attemptCount) {
            startRound(cars)
            resultView.displayCarMovement(cars)
        }
        val raceWinners = getRaceWinners(cars)
        resultView.displayRaceWinners(raceWinners)
    }

    private fun getCarList(carNames: List<String>): List<Car> {
        return carNames.map { name -> Car(name = name) }
    }

    private fun startRound(
        cars: List<Car>,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT,
        numberGenerator: NumberGenerator = this.numberGenerator,
    ) {
        fun move(car: Car) = car.move(forwardLimit, numberGenerator)
        cars.forEach(::move)
    }

    private fun getRaceWinners(cars: List<Car>): List<String> {
        val groupedByPosition = cars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        return groupedByPosition[maxPosition]?.map { it.name } ?: emptyList()
    }
}
