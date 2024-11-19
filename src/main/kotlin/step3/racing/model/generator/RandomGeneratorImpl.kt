package step3.racing.model.generator

internal class RandomGeneratorImpl(private val range: IntRange) : NumberGenerator {
    override fun generator(): Int {
        return range.random()
    }
}
