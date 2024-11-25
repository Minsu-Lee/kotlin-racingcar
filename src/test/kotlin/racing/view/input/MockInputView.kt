package racing.view.input

class MockInputView(
    private val carNames: List<String>,
    private val attemptCount: Int,
) : InputView {

    override fun inputCarNames(): List<String> {
        return carNames
    }

    override fun inputAttemptCount(): Int {
        return attemptCount
    }
}
