package racing.model

object EngineFactory {
    fun create(range: IntRange = Engine.DEFAULT_RANDOM_RANGE): Engine {
        return Engine(range)
    }
}
