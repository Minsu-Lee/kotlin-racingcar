package racing.controller

import racing.model.Car

interface RacingController {
    fun start()

    fun getCarList(carNames: List<String>): List<Car>

    fun startRound(cars: List<Car>)

    fun startRound(
        cars: List<Car>,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT
    )

    fun getRaceWinners(cars: List<Car>): List<String>
}
