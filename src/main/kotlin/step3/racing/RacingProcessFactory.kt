package step3.racing

object RacingProcessFactory {
    fun newInstance(numberGenerator: NumberGenerator): RacingProcess {
        return RacingProcessImpl(numberGenerator)
    }
}
