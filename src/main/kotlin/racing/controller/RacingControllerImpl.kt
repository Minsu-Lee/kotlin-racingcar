package racing.controller

import racing.model.Car
import racing.model.Engine
import racing.view.input.InputView
import racing.view.result.ResultView

class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView
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
        val engine = Engine(0..9)
        return carNames.map { name -> Car(name, engine) }
    }

    override fun startRound(cars: List<Car>) {
        startRound(cars, Car.DEFAULT_FORWARD_LIMIT)
    }

    override fun startRound(
        cars: List<Car>,
        forwardLimit: Int
    ) {
        cars.forEach { it.move(forwardLimit) }
    }

    override fun getRaceWinners(cars: List<Car>): List<String> {
        val groupedByPosition = cars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        return groupedByPosition[maxPosition]?.map { it.name } ?: emptyList()
    }
}
