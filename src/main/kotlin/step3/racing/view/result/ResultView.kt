package step3.racing.view.result

import step3.racing.model.car.Car

sealed interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(cars: List<Car>)
}
