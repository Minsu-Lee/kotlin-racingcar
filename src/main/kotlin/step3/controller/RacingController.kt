package step3.controller

import step3.model.RacingProcess
import step3.model.RacingProcessFactory
import step3.model.RandomGenerator
import step3.model.RandomGeneratorFactory
import step3.view.InputView
import step3.view.InputViewFactory
import step3.view.ResultView
import step3.view.ResultViewFactroy

fun main() {
    val inputView: InputView = InputViewFactory.newInstance()
    val randomGenerator: RandomGenerator = RandomGeneratorFactory.newInstance()
    val resultView: ResultView = ResultViewFactroy.newInstance()
    val racingProcess: RacingProcess = RacingProcessFactory.newInstance(randomGenerator)
    val racingController = RacingControllerFactory.newInstance(inputView, resultView, racingProcess)
    racingController.start()
}

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
