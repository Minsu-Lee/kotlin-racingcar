package step3.racing.model.car

import step3.racing.model.generator.NumberGenerator
import step3.racing.model.generator.RandomGeneratorFactory

class Car(
    var carCount: Int = DEFAULT_CAR_COUNT,
    var attemptCount: Int = DEFAULT_ATTEMPT_COUNT,
    position: Int = DEFAULT_POSITION,
    private val forwardLimit: Int = DEFAULT_FORWARD_LIMIT,
    private val numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance(),
) {
    var position: Int = position
        private set

    fun move() {
        val number = numberGenerator.generator()
        validCarCount(carCount)
        validAttemptCount(attemptCount)

        if (number >= forwardLimit) {
            position++
        }
    }

    fun repeatSymbolForPosition(symbol: Char): String {
        return "$symbol".repeat(position)
    }

    private fun validCarCount(carCount: Int) {
        if (carCount == 0) {
            throw IllegalArgumentException("자동차 대수는 최소 1대 이상이어야 합니다.")
        }
    }

    private fun validAttemptCount(attemptCount: Int) {
        if (attemptCount == 0) {
            throw IllegalArgumentException("시도 횟수는 최소 1번 이상이어야 합니다.")
        }
    }

    companion object {
        const val DEFAULT_CAR_COUNT = 1
        const val DEFAULT_ATTEMPT_COUNT = 1
        const val DEFAULT_FORWARD_LIMIT = 4
        const val DEFAULT_MOVE_SYMBOL = '-'
        private const val DEFAULT_POSITION = 0
    }
}
