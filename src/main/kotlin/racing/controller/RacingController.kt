package racing.controller

import racing.model.car.Car
import racing.service.generator.NumberGenerator

interface RacingController {
    fun start()

    fun getCarList(carNames: List<String>): List<Car>

    fun startRound(cars: List<Car>)

    fun startRound(
        cars: List<Car>,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT,
        numberGenerator: NumberGenerator,
    )

    fun getRaceWinners(cars: List<Car>): List<String>
}
