package racing.view.result

import racing.model.Car

interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(
        car: Car,
        hasRoundEnded: Boolean,
    )

    fun displayRaceWinners(carNames: List<Car>)
}
