package racing.model

object EngineFactory {
    fun create(
        range: IntRange = IntRangeEngine.DEFAULT_RANDOM_RANGE,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT,
    ): IntRangeEngine {
        return IntRangeEngine(range, forwardLimit)
    }
}
