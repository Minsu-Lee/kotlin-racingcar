package racing.model

class Engine(private val range: IntRange = DEFAULT_RANDOM_RANGE) {
    fun canMoveForward(forwardLimit: Int): Boolean {
        val number = range.random()
        return number >= forwardLimit
    }

    companion object {
        val DEFAULT_RANDOM_RANGE = 0..9
    }
}
