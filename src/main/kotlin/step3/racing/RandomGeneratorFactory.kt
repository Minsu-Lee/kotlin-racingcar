package step3.racing

object RandomGeneratorFactory {
    fun newInstance(): NumberGenerator {
        return RandomGeneratorImpl()
    }
}
