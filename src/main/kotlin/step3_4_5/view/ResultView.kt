package step3_4_5.view

import step3_4_5.domain.racing.Car

object ResultView {
    fun showResult(carList: List<Car>) {
        carList.forEach { car ->
            showSingleCarRacingResult(car)
        }
        println()
    }

    private fun showSingleCarRacingResult(car: Car) {
        print("${car.carName} $DELIMITER ")
        for (i in MINIMUM_STEP..car.currentStep()) {
            print(MOVED_DISTANCE)
        }
        println()
    }

    fun showLastResult(carList: List<Car>) {
        val winnerStep = carList.maxOf { it.currentStep() }
        val winnersCarList = carList.sortedByDescending { it.currentStep() }.filter { it.currentStep() == winnerStep }
        val winnersCarName = winnersCarList.joinToString(SEPARATOR) { it.carName }
        println("$winnersCarName$IS_FINAL_WINNER")
    }

    private const val DELIMITER = ":"
    private const val MINIMUM_STEP = 1
    private const val MOVED_DISTANCE = "-"
    private const val IS_FINAL_WINNER = "(이)가 최종 우승했습니다."
    private const val SEPARATOR = ","
}
