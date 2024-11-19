package step3.racing

internal class RacingProcessImpl(
    private val numberGenerator: NumberGenerator,
) : RacingProcess {
    override fun execute(
        carCount: Int,
        attemptCount: Int,
        minRandomValue: Int,
    ): Array<Array<Int>> {
        val moveCounts: Array<Array<Int>> =
            Array(carCount) {
                Array(attemptCount) { 0 }
            }

        repeat(carCount) { carIndex ->
            repeat(attemptCount) { attemptIndex ->
                val randomNumber = numberGenerator.generator()
                if (randomNumber >= minRandomValue) {
                    moveCounts[carIndex][attemptIndex] = 1
                }
            }
        }

        return moveCounts
    }
}
