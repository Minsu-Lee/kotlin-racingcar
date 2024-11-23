package racing.model

class RacingTrack(
    private val cars: List<Car>,
    private val attemptCount: Int,
) {
    fun startRound(
        forwardLimit: Int,
        block: (Car, Boolean) -> Unit = { _, _ -> },
    ) {
        repeat(attemptCount) {
            cars.forEachIndexed { index, car ->
                car.move(forwardLimit)

                val hasRoundEnded = hasRoundEnded(index)
                block(car, hasRoundEnded)
            }
        }
    }

    private fun hasRoundEnded(index: Int): Boolean {
        return cars.size.minus(1) <= index
    }

    fun getRaceWinners(): List<String> {
        val groupedByPosition = cars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        val target = groupedByPosition[maxPosition]?.filter { it.position > 0 }
        return target?.map { it.name } ?: emptyList()
    }
}
