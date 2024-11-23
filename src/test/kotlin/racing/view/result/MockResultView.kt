package racing.view.result

import racing.model.Car

class MockResultView(
    private val displayCarMovementBlock: (car: Car, hasRoundEnded: Boolean) -> Unit = { _, _ -> },
    private val displayRaceWinnersBlock: (List<String>) -> Unit = {},
) : ResultView {
    override fun printOutputTitle() { }

    override fun displayCarMovement(
        car: Car,
        hasRoundEnded: Boolean,
    ) = displayCarMovementBlock(car, hasRoundEnded)

    override fun displayRaceWinners(carNames: List<String>) = displayRaceWinnersBlock(carNames)
}
