package step3.racing

object RandomGeneratorFactory {
    fun newInstance(): RandomGenerator {
        return RandomGeneratorImpl()
    }
}
