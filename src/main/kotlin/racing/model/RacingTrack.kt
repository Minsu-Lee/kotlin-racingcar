package racing.model

class RacingTrack(
    private val cars: List<Car>,
    private val attemptCount: Int,
) {
    fun startRound(onRoundProgress: (car: Car, hasRoundEnded: Boolean) -> Unit = { _, _ -> }) {
        repeat(attemptCount) {
            cars.forEachIndexed { index, car ->
                car.move()

                val hasRoundEnded = cars.size.minus(1) <= index
                onRoundProgress(car, hasRoundEnded)
            }
        }
    }
}
