package step3.racing

internal class RandomGeneratorImpl : RandomGenerator {
    override fun generator(range: IntRange): Int {
        return range.random()
    }
}
