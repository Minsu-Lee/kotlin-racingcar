package step3.racing.view.input

sealed interface InputView {
    fun printCarCountQuestion()

    fun printAttemptCountQuestion()

    fun inputNumber(input: String?): Int

    fun promptForNumberInput(questionBlock: () -> Unit): Int

    fun promptAndValidateCarCountInput(): Int

    fun promptAndValidateAttemptCountInput(): Int
}
