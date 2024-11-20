package racing.model.car

import racing.model.generator.NumberGenerator
import racing.model.generator.RandomGeneratorFactory

class Car(
    position: Int = DEFAULT_POSITION,
    private val forwardLimit: Int = DEFAULT_FORWARD_LIMIT,
    private val numberGenerator: NumberGenerator = RandomGeneratorFactory.newInstance(),
) {
    var position: Int = position
        private set

    fun move() {
        val number = numberGenerator.generator()
        if (number >= forwardLimit) {
            position++
        }
    }

    companion object {
        const val DEFAULT_FORWARD_LIMIT = 4
        private const val DEFAULT_POSITION = 0
    }
}
