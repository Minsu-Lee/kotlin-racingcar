package step3.racing.view.result

import step3.racing.model.car.Car

internal class ResultViewImpl(
    private val moveSymbol: Char,
) : ResultView {
    override fun printOutputTitle() {
        println("실행결과")
    }

    override fun displayCarMovement(cars: List<Car>) {
        cars.forEach { car ->
            val symbolTrack = car.repeatSymbolForPosition(moveSymbol)
            println(symbolTrack)
        }
        println()
    }
}
