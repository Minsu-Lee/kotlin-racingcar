package racing.view.input

import racing.model.InputValidator

internal class ConsoleInputView : InputView {
    override fun displayCarNamesQuestion() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    override fun inputCarNames(): List<String> {
        val input = readlnOrNull()
        val validatedInput = InputValidator.requireValidCarNamesInput(input)
        return splitCarNames(validatedInput)
    }

    private fun splitCarNames(input: String): List<String> {
        return input.split(DELIMITER_COMMA).map { it.trim() }
    }

    override fun displayAttemptCountQuestion() {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun inputAttemptCount(): Int {
        val input = readlnOrNull()
        val validatedAttemptCount = InputValidator.requireValidAttemptCountInput(input).toInt()
        return validatedAttemptCount
    }

    companion object {
        const val DELIMITER_COMMA = ','
        const val DEFAULT_NAME_MAX = 5
    }
}
