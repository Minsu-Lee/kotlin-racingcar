package racing.model

class Car(
    val name: String,
    private val engine: Engine,
) {
    var position: Int
        private set

    init {
        position = 0
        CarValidator.validateNameLength(name)
    }

    fun move() {
        val canMoveForward = engine.canMoveForward()
        if (canMoveForward) {
            position++
        }
    }

    companion object {
        const val DEFAULT_FORWARD_LIMIT = 4
        const val MAX_NAME_LENGTH = 5
    }
}
