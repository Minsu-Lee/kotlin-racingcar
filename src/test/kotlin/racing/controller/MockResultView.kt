package racing.controller

import racing.model.car.Car
import racing.view.result.ResultView

interface MockResultView : ResultView {
    override fun printOutputTitle() { }

    override fun displayCarMovement(cars: List<Car>) { }

    override fun displayRaceWinners(carNames: List<String>) { }
}
