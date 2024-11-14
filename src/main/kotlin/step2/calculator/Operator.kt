package step2.calculator

enum class Operator(protected var char: Char?) {
    PLUS('+'),
    MINUS('-'),
    TIMES('*'),
    DIV('/'),
    DEFAULT(null),
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
                '+' -> PLUS
                '-' -> MINUS
                '*' -> TIMES
                '/' -> DIV
                else -> toDefault(char)
            }
        }

        private fun toDefault(char: Char?): Operator {
            return DEFAULT.apply {
                this.char = char
            }
        }
    }
}
