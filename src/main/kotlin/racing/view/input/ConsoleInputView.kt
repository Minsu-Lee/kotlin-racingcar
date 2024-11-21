package racing.view.input

internal class ConsoleInputView : InputView {
    override fun displayCarNamesQuestion() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    override fun displayAttemptCountQuestion() {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun inputCarNames(input: String?): List<String> {
        val validatedInput = validateCarNamesInput(input)
        return validatedInput.split(DELIMITER_COMMA).map { it.trim() }
    }

    override fun inputNumber(input: String?): Int {
        return validateIntInput(input).toInt()
    }

    override fun promptForCharNames(questionBlock: () -> Unit): List<String> {
        questionBlock()
        val inputCarNames = validateAndGetCarNames(questionBlock = questionBlock)
        return inputCarNames
    }

    override fun promptForNumberInput(questionBlock: () -> Unit): Int {
        questionBlock()
        val inputNumber = validateAndGetNumber(questionBlock = questionBlock)
        return inputNumber
    }

    override fun promptAndValidateCarNamesInput(): List<String> {
        return promptForCharNames(::displayCarNamesQuestion)
    }

    override fun promptAndValidateAttemptCountInput(): Int {
        return promptForNumberInput(::displayAttemptCountQuestion)
    }

    private fun validateAndGetCarNames(
        input: String? = readlnOrNull(),
        questionBlock: () -> Unit,
    ): List<String> {
        return try {
            inputCarNames(input)
        } catch (e: IllegalArgumentException) {
            questionBlock()
            validateAndGetCarNames(questionBlock = questionBlock)
        }
    }

    private fun validateAndGetNumber(
        input: String? = readlnOrNull(),
        questionBlock: () -> Unit,
    ): Int {
        return try {
            inputNumber(input)
        } catch (e: IllegalArgumentException) {
            questionBlock()
            validateAndGetNumber(questionBlock = questionBlock)
        }
    }

    private fun validateCarNamesInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "입력값을 확인해주세요." }
        require(input.split(DELIMITER_COMMA).none { it.trim().length > 5 }) {
            "자동차 이름은 ${DEFAULT_NAME_MAX}자를 초과할 수 없습니다."
        }
        return input
    }

    private fun validateIntInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "입력값을 확인해주세요." }
        require(input.toIntOrNull() != null) { "숫자를 입력해주세요." }
        require(input.toInt() > 0) { "최소 0보다 큰수를 입력해주세요." }
        return input
    }

    companion object {
        private const val DELIMITER_COMMA = ','
        private const val DEFAULT_NAME_MAX = 5
    }
}
