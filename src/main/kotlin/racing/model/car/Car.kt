package racing.model.car

import racing.model.generator.NumberGenerator
import racing.model.generator.RandomGeneratorFactory

class Car(position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    fun move() {
        val numberGenerator = RandomGeneratorFactory.newInstance()
        move(DEFAULT_FORWARD_LIMIT, numberGenerator)
    }

    fun move(
        forwardLimit: Int = DEFAULT_FORWARD_LIMIT,
        numberGenerator: NumberGenerator,
    ) {
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
