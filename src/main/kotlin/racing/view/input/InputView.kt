package racing.view.input

interface InputView {
    fun displayCarNamesQuestion()

    fun displayAttemptCountQuestion()

    fun inputCarNames(input: String?): List<String>

    fun inputNumber(input: String?): Int

    fun promptForCharNames(questionBlock: () -> Unit): List<String>

    fun promptForNumberInput(questionBlock: () -> Unit): Int

    fun promptAndValidateCarNamesInput(): List<String>

    fun promptAndValidateAttemptCountInput(): Int
}
