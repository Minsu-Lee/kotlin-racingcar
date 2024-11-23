package racing.controller

import racing.GameContext
import racing.view.input.InputView
import racing.view.result.ResultView

object RacingControllerFactory {
    fun newInstance(
        inputView: InputView,
        resultView: ResultView,
    ): RacingController {
        val gameContext = GameContext(inputView, resultView)
        return newInstance(gameContext)
    }

    private fun newInstance(gameContext: GameContext): RacingController {
        return RacingControllerImpl(gameContext)
    }
}
