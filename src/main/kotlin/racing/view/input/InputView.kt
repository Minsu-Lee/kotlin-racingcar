package racing.view.input

interface InputView : InputDisplayView {
    fun inputCarNames(): List<String>

    fun inputAttemptCount(): Int
}
