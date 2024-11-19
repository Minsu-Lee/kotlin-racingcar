package step3.racing

object RacingProcessFactory {
    fun newInstance(randomGenerator: RandomGenerator): RacingProcess {
        return RacingProcessImpl(randomGenerator)
    }
}
