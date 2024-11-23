package racing.controller

import racing.GameContext
import racing.model.Car
import racing.model.RacingTrack

class RacingControllerImpl(private val gameContext: GameContext) : RacingController {
    override fun start() {
        with(gameContext) {
            val carNames = inputView.promptAndValidateCarNamesInput()
            val attemptCount = inputView.promptAndValidateAttemptCountInput()
            val cars = createCars(carNames)
            val racingTrack = RacingTrack(cars, attemptCount)

            resultView.printOutputTitle()
            val winner =
                racingTrack.startRound(
                    forwardLimit = Car.DEFAULT_FORWARD_LIMIT,
                    onRoundProgress = resultView::displayCarMovement,
                )
            resultView.displayRaceWinners(winner)
        }
    }
}
