package racing.model.generator

internal class RandomGeneratorImpl(private val range: IntRange) : racing.model.generator.NumberGenerator {
    override fun generator(): Int {
        return range.random()
    }
}
