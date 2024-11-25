package racing.model

class Car(
    val name: String,
    private val engine: Engine,
) {
    private val forwardRecords: MutableList<Int> = mutableListOf()

    val position: Int
        get() = forwardRecords.sum()

    init {
        CarValidator.validateNameLength(name)
    }

    fun getPosition(attemptIndex: Int): Int {
        return forwardRecords.subList(0, attemptIndex + 1).sum()
    }

    fun move() {
        val canMoveForward = engine.canMoveForward(DEFAULT_FORWARD_LIMIT)
        forwardRecords.add(if (canMoveForward) 1 else 0)
    }

    companion object {
        const val DEFAULT_FORWARD_LIMIT = 4
        const val MAX_NAME_LENGTH = 5
    }
}
