package step3.racing.model

import step3.racing.NumberGenerator
import step3.racing.RandomGeneratorFactory

class Car(
    var carCount: Int = DEFAULT_CAR_COUNT,
    var attemptCount: Int = DEFAULT_ATTEMPT_COUNT,
    position: Int = DEFAULT_POSITION,
    private val minLimit: Int = DEFAULT_MIN_RANDOM_VALUE,
    private val numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance(),
) {

    var position: Int = position
        private set

    fun move() {
        val number = numberGenerator.generator()
        move(number, minLimit)
    }

    fun move(number: Int, forwardLimit: Int) {
        validCarCount(carCount)
        validAttemptCount(attemptCount)
        if (number >= forwardLimit) {
            position++
        }
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
        private const val DEFAULT_CAR_COUNT = 1
        private const val DEFAULT_ATTEMPT_COUNT = 1
        private const val DEFAULT_POSITION = 0
        private const val DEFAULT_MIN_RANDOM_VALUE = 4
    }
}
