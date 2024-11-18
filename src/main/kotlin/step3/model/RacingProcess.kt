package step3.model

interface RacingProcess {
    fun execute(
        carCount: Int,
        attemptCount: Int,
        minRandomValue: Int,
    ): Array<Array<Int>>
}

object RacingProcessFactory {
    fun newInstance(randomGenerator: RandomGenerator): RacingProcess {
        return RacingProcessImpl(randomGenerator)
    }
}

private class RacingProcessImpl(
    private val randomGenerator: RandomGenerator,
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
                val range = 1 until 10
                val randomNumber = randomGenerator.generator(range = range)
                if (randomNumber >= minRandomValue) {
                    moveCounts[carIndex][attemptIndex] = 1
                }
            }
        }

        return moveCounts
    }
}
