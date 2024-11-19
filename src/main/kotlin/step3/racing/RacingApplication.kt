package step3.racing

import step3.racing.controller.RacingControllerFactory
import step3.racing.view.InputView
import step3.racing.view.InputViewFactory
import step3.racing.view.ResultView
import step3.racing.view.ResultViewFactroy

fun main() {
    val inputView: InputView = InputViewFactory.newInstance()
    val randomGenerator: RandomGenerator = RandomGeneratorFactory.newInstance()
    val resultView: ResultView = ResultViewFactroy.newInstance()
    val racingProcess: RacingProcess = RacingProcessFactory.newInstance(randomGenerator)
    val racingController = RacingControllerFactory.newInstance(inputView, resultView, racingProcess)
    racingController.start()
}
