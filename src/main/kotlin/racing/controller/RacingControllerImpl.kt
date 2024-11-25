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
            racingTrack.startRound()
            resultView.displayCarMovement(cars, attemptCount)

            val winner = racingTrack.getRaceWinners()
            resultView.displayRaceWinners(winner)
        }
    }
}
