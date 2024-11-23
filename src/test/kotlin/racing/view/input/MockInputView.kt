package racing.view.input

interface MockInputView: InputView {
    fun inputCarNames(input: String?): List<String>
    fun inputNumber(input: String?): Int
}