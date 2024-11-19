package step3.racing.controller

import step3.racing.model.generator.NumberGenerator
import step3.racing.model.generator.RandomGeneratorFactory
import step3.racing.view.input.InputView
import step3.racing.view.result.ResultView

object RacingControllerFactory {
    fun newInstance(
        inputView: InputView,
        resultView: ResultView,
        numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance(),
    ): RacingController {
        return RacingControllerImpl(
            inputView,
            resultView,
            numberGenerator,
        )
    }
}
