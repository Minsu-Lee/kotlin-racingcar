package racing.controller

import racing.model.Car
import racing.model.CarFactory
import racing.model.Engine
import racing.model.RacingTrack
import racing.view.input.InputView
import racing.view.result.ResultView

class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
) : RacingController {
    override fun start() {
        val carNames = inputView.promptAndValidateCarNamesInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()
        val cars = CarFactory.createCars(carNames, ::engineProvider)
        val racingTrack = RacingTrack(cars, attemptCount)

        resultView.printOutputTitle()
        with(racingTrack) {
            startRound(Car.DEFAULT_FORWARD_LIMIT, resultView::displayCarMovement)
            val winner = getRaceWinners()
            resultView.displayRaceWinners(winner)
        }
    }

    private fun engineProvider(range: IntRange = Engine.DEFAULT_RANDOM_RANGE): Engine {
        return Engine(range)
    }
}
