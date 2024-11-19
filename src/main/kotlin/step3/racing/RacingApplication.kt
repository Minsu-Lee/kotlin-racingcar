package step3.racing

import step3.racing.controller.RacingControllerFactory
import step3.racing.model.generator.NumberGenerator
import step3.racing.model.generator.RandomGeneratorFactory
import step3.racing.view.input.InputView
import step3.racing.view.input.InputViewFactory
import step3.racing.view.result.ResultFactory
import step3.racing.view.result.ResultView

fun main() {
    val inputView: InputView = InputViewFactory.newInstance()
    val resultView: ResultView = ResultFactory.newInstance()
    val numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance()
    val racingController = RacingControllerFactory.newInstance(inputView, resultView, numberGenerator)
    racingController.start()
}
