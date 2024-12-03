package racing.model

class RacingTrack(
    private val cars: Cars,
    private val attemptCount: Int,
) {
    fun startRound(onRoundProgress: () -> Unit = {}) {
        repeat(attemptCount) {
            cars.moveAll()
            onRoundProgress()
        }
    }
}
