package racing.controller

import racing.GameContext
import racing.model.RacingTrack

class RacingControllerImpl(private val gameContext: GameContext) : RacingController {
    override fun start() {
        with(gameContext) {
            inputView.displayCarNamesQuestion()
            val carNames = inputView.inputCarNames()
            inputView.displayAttemptCountQuestion()
            val attemptCount = inputView.inputAttemptCount()
            val cars = createCars(carNames = carNames)
            val racingTrack = RacingTrack(cars = cars, attemptCount = attemptCount)

            resultView.printOutputTitle()
            racingTrack.startRound {
                resultView.displayCarMovement(cars)
            }

            val winner = getRaceWinners(cars)
            resultView.displayRaceWinners(winner)
        }
    }
}
