package step3.racing

internal class RandomGeneratorImpl : NumberGenerator {
    override fun generator(range: IntRange): Int {
        return range.random()
    }
}
