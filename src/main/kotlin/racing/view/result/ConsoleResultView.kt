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
        cars: List<Car>,
        attemptCount: Int,
    ) {
        repeat(attemptCount) { attemptIndex ->
            cars.forEach { car ->
                val carName = car.name
                val position = car.getPosition(attemptIndex)
                val symbolTrack = repeatSymbolForPosition(position, moveSymbol)
                println("$carName : $symbolTrack")
            }
            println()
        }
    }

    private fun repeatSymbolForPosition(
        position: Int,
        symbol: Char,
    ): String {
        return "$symbol".repeat(position)
    }

    override fun displayRaceWinners(carNames: List<Car>) {
        val winners = carNames.joinToString(DELIMITER_COMMA) { it.name }
        println("${winners}가 최종 우승했습니다.")
    }

    companion object {
        private const val DELIMITER_COMMA = ", "
    }
}
