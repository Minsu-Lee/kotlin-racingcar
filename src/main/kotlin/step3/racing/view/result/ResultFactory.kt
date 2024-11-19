package step3.racing.view.result

import step3.racing.model.car.Car

object ResultFactory {
    fun newInstance(moveSymbol: Char = Car.DEFAULT_MOVE_SYMBOL): ResultView {
        return ResultViewImpl(moveSymbol)
    }
}
