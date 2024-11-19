package step3.racing.controller

import step3.racing.RacingProcess
import step3.racing.view.InputView
import step3.racing.view.ResultView

internal class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val racingProcess: RacingProcess,
) : RacingController {
    override fun start() {
        val carCount = inputView.promptAndValidateCarCountInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()
        val moveCounts = racingProcess.execute(carCount, attemptCount, DEFAULT_MIN_RANDOM_VALUE)
        resultView.displayCarMovement(moveCounts, carCount, attemptCount, DEFAULT_MOVE_SYMBOL)
    }

    companion object {
        private const val DEFAULT_MIN_RANDOM_VALUE = 4
        private const val DEFAULT_MOVE_SYMBOL = '-'
    }
}
