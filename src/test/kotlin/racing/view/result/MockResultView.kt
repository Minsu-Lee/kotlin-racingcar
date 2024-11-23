package racing.view.result

import racing.model.Car

class MockResultView(
    private val displayCarMovementBlock: (List<Car>)->Unit = {},
    private val displayRaceWinnersBlock: (List<String>)->Unit = {}
) : ResultView {
    override fun printOutputTitle() { }

    override fun displayCarMovement(cars: List<Car>) = displayCarMovementBlock(cars)

    override fun displayRaceWinners(carNames: List<String>) = displayRaceWinnersBlock(carNames)
}
