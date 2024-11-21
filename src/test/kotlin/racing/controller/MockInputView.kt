package racing.controller

import racing.view.input.InputView

interface MockInputView : InputView {
    override fun displayCarNamesQuestion() = throw NotImplementedError()

    override fun displayAttemptCountQuestion() = throw NotImplementedError()

    override fun inputCarNames(input: String?): List<String> = throw NotImplementedError()

    override fun inputNumber(input: String?): Int = throw NotImplementedError()

    override fun promptForCharNames(questionBlock: () -> Unit): List<String> = throw NotImplementedError()

    override fun promptForNumberInput(questionBlock: () -> Unit): Int = throw NotImplementedError()

    override fun promptAndValidateCarNamesInput(): List<String> = throw NotImplementedError()

    override fun promptAndValidateAttemptCountInput(): Int = throw NotImplementedError()
}
