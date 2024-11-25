package racing.view.result

import racing.model.Car

class MockResultView(
    private val displayCarMovementBlock: (cars: List<Car>, attemptCount: Int) -> Unit = { _, _ -> },
    private val displayRaceWinnersBlock: (List<Car>) -> Unit = {},
) : ResultView {
    override fun printOutputTitle() { }

    override fun displayCarMovement(
        cars: List<Car>,
        attemptCount: Int,
    ) {
        displayCarMovementBlock(cars, attemptCount)
    }

    override fun displayRaceWinners(carNames: List<Car>) = displayRaceWinnersBlock(carNames)
}
