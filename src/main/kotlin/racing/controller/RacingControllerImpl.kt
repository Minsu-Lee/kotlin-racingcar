package racing.controller

import racing.GameContext
import racing.model.CarFactory
import racing.model.RacingTrack

class RacingControllerImpl(
    private val gameContext: GameContext,
) : RacingController {
    override fun start() {
        with(gameContext) {
            displayCarNamesQuestion()
            val carNames = inputView.inputCarNames()
            displayAttemptCountQuestion()
            val attemptCount = inputView.inputAttemptCount()
            val cars = CarFactory.createCars(carNames)
            val racingTrack = RacingTrack(cars = cars, attemptCount = attemptCount)

            resultView.printOutputTitle()
            racingTrack.startRound {
                resultView.displayCarMovement(cars)
            }

            val winner = cars.getRaceWinners()
            resultView.displayRaceWinners(winner)
        }
    }

    private fun displayCarNamesQuestion() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    private fun displayAttemptCountQuestion() {
        println("시도할 횟수는 몇 회인가요?")
    }
}
