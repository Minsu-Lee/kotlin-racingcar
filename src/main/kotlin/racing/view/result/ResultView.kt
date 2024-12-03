package racing.view.result

import racing.model.Cars

interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(cars: Cars)

    fun displayRaceWinners(cars: Cars)
}
