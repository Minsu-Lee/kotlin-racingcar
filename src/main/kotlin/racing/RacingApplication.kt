package racing

import racing.controller.RacingControllerFactory
import racing.service.generator.NumberGenerator
import racing.service.generator.RandomGeneratorFactory
import racing.view.input.ConsoleInputViewFactory
import racing.view.input.InputView
import racing.view.result.ConsoleResultViewFactory
import racing.view.result.ResultView

fun main() {
    val inputView: InputView = ConsoleInputViewFactory.newInstance()
    val resultView: ResultView = ConsoleResultViewFactory.newInstance()
    val numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance()
    val racingController = RacingControllerFactory.newInstance(inputView, resultView, numberGenerator)
    racingController.start()
}
