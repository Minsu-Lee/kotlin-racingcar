package racing.controller

import racing.model.generator.NumberGenerator
import racing.model.generator.RandomGeneratorFactory
import racing.view.input.InputView
import racing.view.result.ResultView

object RacingControllerFactory {
    fun newInstance(
        inputView: InputView,
        resultView: ResultView,
        numberGenerator: racing.model.generator.NumberGenerator = RandomGeneratorFactory.newInstance(),
    ): RacingController {
        return RacingControllerImpl(
            inputView,
            resultView,
            numberGenerator,
        )
    }
}
