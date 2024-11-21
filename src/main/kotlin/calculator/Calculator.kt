package calculator

sealed interface Calculator {
    fun calculate(initialInput: String?): Int
}

object CalculatorFactory {
    fun newInstance(): Calculator {
        return CalculatorImpl()
    }
}

private class CalculatorImpl : Calculator {
    override fun calculate(initialInput: String?): Int {
        val rawInput = OperationInputFactory.newInstance()
        val input = initialInput ?: throw IllegalArgumentException("계산식이 입력되지 않았습니다.")
        val trimmedInput = input.replace(" ", "")

        trimmedInput.forEach { char ->
            if (isReadyToCalculate(char, rawInput)) {
                val result = rawInput.getResult()
                rawInput.initialize()
                rawInput.setFirstInput(result)
                rawInput.setOperator(Operator.toOperator(char))
            } else {
                rawInput.append(char)
            }
        }

        return rawInput.getResultIntOrZero()
    }

    private fun isReadyToCalculate(
        char: Char?,
        rawInput: OperationInput,
    ): Boolean {
        return Operator.isOperator(char) && rawInput.isReady()
    }
}
