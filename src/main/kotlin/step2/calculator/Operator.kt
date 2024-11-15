package step2.calculator

enum class Operator(protected var char: Char?) {
    PLUS('+'),
    MINUS('-'),
    TIMES('*'),
    DIV('/'),
    ;

    companion object {
        private val operators: CharArray by lazy {
            "+-*/".toCharArray()
        }

        fun isOperator(char: Char?): Boolean {
            return char != null && operators.contains(char)
        }

        fun isOperator(operator: Operator?): Boolean {
            return isOperator(operator?.char)
        }

        fun toOperator(char: Char?): Operator {
            return when (char) {
                PLUS.char -> PLUS
                MINUS.char -> MINUS
                TIMES.char -> TIMES
                DIV.char -> DIV
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }
}
