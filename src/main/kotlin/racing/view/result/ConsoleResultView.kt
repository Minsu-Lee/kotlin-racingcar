package racing.view.result

import racing.model.Car

internal class ConsoleResultView(
    private val moveSymbol: Char,
) : ResultView {
    override fun printOutputTitle() {
        println()
        println("실행결과")
    }

    override fun displayCarMovement(
        car: Car,
        hasRoundEnded: Boolean,
    ) {
        val carName = car.name
        val symbolTrack = repeatSymbolForPosition(car.position, moveSymbol)
        println("$carName : $symbolTrack")
        if (hasRoundEnded) {
            println()
        }
    }

    private fun repeatSymbolForPosition(
        position: Int,
        symbol: Char,
    ): String {
        return "$symbol".repeat(position)
    }

    override fun displayRaceWinners(carNames: List<String>) {
        val winners = carNames.joinToString(DELIMITER_COMMA)
        println("${winners}가 최종 우승했습니다.")
    }

    companion object {
        private const val DELIMITER_COMMA = ", "
    }
}
