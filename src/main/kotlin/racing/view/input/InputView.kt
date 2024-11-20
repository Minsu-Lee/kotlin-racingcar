package racing.view.input

sealed interface InputView {
    fun printCarCountQuestion()

    fun printAttemptCountQuestion()

    fun handleNewLine()

    fun inputNumber(input: String?): Int

    fun promptForNumberInput(questionBlock: () -> Unit): Int

    fun promptAndValidateCarCountInput(): Int

    fun promptAndValidateAttemptCountInput(): Int
}
