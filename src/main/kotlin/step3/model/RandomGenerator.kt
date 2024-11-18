package step3.model

interface RandomGenerator {
    fun generator(range: IntRange): Int
}

object RandomGeneratorFactory {
    fun newInstance(): RandomGenerator {
        return RandomGeneratorImpl()
    }
}

private class RandomGeneratorImpl : RandomGenerator {
    override fun generator(range: IntRange): Int {
        return range.random()
    }
}
