package step3.racing.controller

import step3.racing.model.RacingProcess
import step3.racing.view.InputView
import step3.racing.view.ResultView

sealed interface RacingController {
    fun start()
}

object RacingControllerFactory {
    fun newInstance(
        inputView: InputView,
        resultView: ResultView,
        racingProcess: RacingProcess,
    ): RacingController {
        return RacingControllerImpl(
            inputView,
            resultView,
            racingProcess,
        )
    }
}

private class RacingControllerImpl(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val racingProcess: RacingProcess,
) : RacingController {
    override fun start() {
        val carCount = inputView.promptAndValidateCarCountInput()
        val attemptCount = inputView.promptAndValidateAttemptCountInput()
        val minRandomValue = 4
        val moveSymbol = '-'
        val moveCounts = racingProcess.execute(carCount, attemptCount, minRandomValue)
        resultView.displayCarMovement(moveCounts, carCount, attemptCount, moveSymbol)
    }
}
