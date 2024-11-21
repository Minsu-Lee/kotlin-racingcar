package racing.service.generator

object RandomGeneratorFactory {
    private val DEFAULT_RANDOM_RANGE = 0..9

    fun newInstance(range: IntRange = DEFAULT_RANDOM_RANGE): NumberGenerator {
        return RandomGeneratorImpl(range)
    }
}
