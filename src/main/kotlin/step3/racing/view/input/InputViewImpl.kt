package step3.racing.view.input

internal class InputViewImpl : InputView {
    override fun printCarCountQuestion() {
        println("자동차 대수는 몇 대인가요?")
    }

    override fun printAttemptCountQuestion() {
        println("시도할 횟수는 몇 회인가요?")
    }

    override fun inputNumber(input: String?): Int {
        return validateIntInput(input).toInt()
    }

    override fun promptForNumberInput(questionBlock: () -> Unit): Int {
        questionBlock.invoke()
        val inputNumber = validateAndGetNumber(questionBlock = questionBlock)
        return inputNumber
    }

    override fun promptAndValidateCarCountInput(): Int {
        return promptForNumberInput(::printCarCountQuestion)
    }

    override fun promptAndValidateAttemptCountInput(): Int {
        return promptForNumberInput(::printAttemptCountQuestion)
    }

    private fun validateAndGetNumber(
        input: String? = readlnOrNull(),
        questionBlock: () -> Unit,
    ): Int {
        return try {
            inputNumber(input)
        } catch (e: IllegalArgumentException) {
            questionBlock.invoke()
            validateAndGetNumber(questionBlock = questionBlock)
        }
    }

    private fun validateIntInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "입력값을 확인해주세요." }
        require(input.toIntOrNull() != null) { "숫자를 입력해주세요." }
        require(input.toInt() > 0) { "최소 0보다 큰수를 입력해주세요." }
        return input
    }
}
