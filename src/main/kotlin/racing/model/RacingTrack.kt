package racing.model

class RacingTrack(
    private val cars: List<Car>,
    private val attemptCount: Int,
) {
    fun startRound(onRoundProgress: () -> Unit = {}) {
        repeat(attemptCount) {
            cars.forEach { car ->
                car.move()
            }
            onRoundProgress()
        }
    }
}
