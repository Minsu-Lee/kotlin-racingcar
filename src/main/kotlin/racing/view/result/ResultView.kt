package racing.view.result

import racing.model.Car

interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(
        cars: List<Car>,
        attemptCount: Int,
    )

    fun displayRaceWinners(carNames: List<Car>)
}
