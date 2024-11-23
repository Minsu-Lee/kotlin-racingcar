package racing.view.input

interface InputView {
    fun promptAndValidateCarNamesInput(): List<String>

    fun promptAndValidateAttemptCountInput(): Int
}
