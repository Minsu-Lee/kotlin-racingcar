package racing.view.result

import racing.model.car.Car

interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(cars: List<Car>)

    fun displayRaceWinners(carNames: List<String>)
}
