package step3.model

import step3.view.ResultView

interface RacingProcess {
    fun execute(
        carCount: Int,
        attemptCount: Int,
        minRandomValue: Int
    ): Array<Int>
}

object RacingProcessFactory {
    fun newInstance(
        randomGenerator: RandomGenerator,
        resultView: ResultView
    ): RacingProcess {
        return RacingProcessImpl(randomGenerator, resultView)
    }
}

private class RacingProcessImpl(
    private val randomGenerator: RandomGenerator,
    private val resultView: ResultView
) : RacingProcess {
    override fun execute(
        carCount: Int,
        attemptCount: Int,
        minRandomValue: Int
    ): Array<Int> {
        val moveCounts = Array(carCount) { 0 }
        resultView.printOutputTitle()

        repeat(attemptCount) {
            repeat(carCount) { carIndex ->
                val range = 1 until 10
                val randomNumber = randomGenerator.generator(range = range)
                if (randomNumber >= minRandomValue) {
                    moveCounts[carIndex] += 1
                }
            }
        }

        return moveCounts
    }
}