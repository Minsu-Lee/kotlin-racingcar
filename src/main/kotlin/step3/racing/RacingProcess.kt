package step3.racing

interface RacingProcess {
    fun execute(
        carCount: Int,
        attemptCount: Int,
        minRandomValue: Int,
    ): Array<Array<Int>>
}
