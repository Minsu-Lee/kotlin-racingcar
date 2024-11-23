package racing.view.input

import racing.view.input.ConsoleInputView.Companion.DEFAULT_NAME_MAX
import racing.view.input.ConsoleInputView.Companion.DELIMITER_COMMA

class MockInputViewImpl(
    private val rawCarNameInput: String?,
    private val rawAttemptCountInput: String?,
) : MockInputView {
    constructor() : this("", "")

    override fun inputCarNames(input: String?): List<String> {
        val validatedInput = validateCarNamesInput(input)
        return validatedInput.split(DELIMITER_COMMA).map { it.trim() }
    }

    override fun inputNumber(input: String?): Int {
        return validateIntInput(input).toInt()
    }

    private fun promptForCharNames(questionBlock: () -> Unit = {}): List<String> {
        questionBlock()
        val inputCarNames = validateAndGetCarNames(input = rawCarNameInput, questionBlock = questionBlock)
        return inputCarNames
    }

    private fun promptForNumberInput(questionBlock: () -> Unit = {}): Int {
        questionBlock()
        val inputNumber = validateAndGetNumber(input = rawAttemptCountInput, questionBlock = questionBlock)
        return inputNumber
    }

    override fun promptAndValidateCarNamesInput(): List<String> {
        return promptForCharNames()
    }

    override fun promptAndValidateAttemptCountInput(): Int {
        return promptForNumberInput()
    }

    private fun validateAndGetCarNames(
        input: String? = rawCarNameInput,
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
        input: String? = rawCarNameInput,
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
}
