package racing.controller

import racing.model.car.Car
import racing.service.generator.NumberGenerator
import racing.view.input.InputView
import racing.view.result.ResultView

class RacingControllerImpl(
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

    override fun getCarList(carNames: List<String>): List<Car> {
        return carNames.map { name -> Car(name = name) }
    }

    override fun startRound(cars: List<Car>) {
        startRound(cars, Car.DEFAULT_FORWARD_LIMIT, this.numberGenerator)
    }

    override fun startRound(
        cars: List<Car>,
        forwardLimit: Int,
        numberGenerator: NumberGenerator,
    ) {
        cars.forEach { it.move(forwardLimit, numberGenerator) }
    }

    override fun getRaceWinners(cars: List<Car>): List<String> {
        val groupedByPosition = cars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        return groupedByPosition[maxPosition]?.map { it.name } ?: emptyList()
    }
}
