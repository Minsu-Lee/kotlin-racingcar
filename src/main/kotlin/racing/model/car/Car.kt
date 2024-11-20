package racing.model.car

import racing.exception.InvalidCarNameException
import racing.model.generator.NumberGenerator
import racing.model.generator.RandomGeneratorFactory

class Car(
    name: String = "",
    position: Int = DEFAULT_POSITION,
) {
    var name: String = validateNameLength(name)
        private set

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

    fun validateNameLength(name: String): String {
        if (name.length > MAX_NAME_LENGTH) {
            throw InvalidCarNameException("자동차의 이름은 ${MAX_NAME_LENGTH}자를 초과할 수 없습니다.")
        }
        return name
    }

    companion object {
        const val DEFAULT_FORWARD_LIMIT = 4
        private const val MAX_NAME_LENGTH = 5
        private const val DEFAULT_POSITION = 0
    }
}
