package step3.racing.controller

import step3.racing.RacingProcess
import step3.racing.view.InputView
import step3.racing.view.ResultView

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
