package racing.model

class RacingTrack(
    private val cars: List<Car>,
    private val attemptCount: Int,
) {
    fun startRound(
        forwardLimit: Int,
        onRoundProgress: (car: Car, hasRoundEnded: Boolean) -> Unit = { _, _ -> },
    ): List<Car> {
        repeat(attemptCount) {
            cars.forEachIndexed { index, car ->
                car.move(forwardLimit)

                val hasRoundEnded = cars.size.minus(1) <= index
                onRoundProgress(car, hasRoundEnded)
            }
        }

        return getRaceWinners()
    }

    private fun getRaceWinners(): List<Car> {
        val validCars = cars.filter { it.position > 0 }
        val groupedByPosition = validCars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        return groupedByPosition[maxPosition] ?: emptyList()
    }
}
