package racing.view.result

import racing.model.Cars

class MockResultView(
    private val displayCarMovementBlock: (cars: Cars) -> Unit = { _ -> },
    private val displayRaceWinnersBlock: (cars: Cars) -> Unit = {},
) : ResultView {
    override fun printOutputTitle() { }

    override fun displayCarMovement(cars: Cars) {
        displayCarMovementBlock(cars)
    }

    override fun displayRaceWinners(cars: Cars) = displayRaceWinnersBlock(cars)
}
