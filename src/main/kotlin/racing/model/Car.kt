package racing.model

import racing.exception.InvalidCarNameException

class Car(
    position: Int,
    val name: String,
    private val engine: Engine,
) {
    init {
        validateNameLength(name)
    }

    constructor(name: String, engine: Engine) : this(DEFAULT_POSITION, name, engine)

    var position: Int = position
        private set

    fun move() {
        if (engine.canMoveForward(DEFAULT_FORWARD_LIMIT)) {
            position++
        }
    }

    private fun validateNameLength(name: String): String {
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
