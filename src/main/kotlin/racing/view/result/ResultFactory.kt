package racing.view.result

import racing.model.car.Car

object ResultFactory {
    fun newInstance(moveSymbol: Char = Car.DEFAULT_MOVE_SYMBOL): ResultView {
        return ResultViewImpl(moveSymbol)
    }
}
