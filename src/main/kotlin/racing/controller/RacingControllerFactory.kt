package racing.controller

import racing.service.generator.NumberGenerator
import racing.service.generator.RandomGeneratorFactory
import racing.view.input.InputView
import racing.view.result.ResultView

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
