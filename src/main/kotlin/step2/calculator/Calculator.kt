package step2.calculator

interface Calculator {
    fun calculate(initialInput: String?): Int
}

object CalculatorFactory {
    fun newInstance(): Calculator {
        return CalculatorImpl()
    }
}

private class CalculatorImpl : Calculator {
    private val rawInput: OperationInput by lazy {
        OperationInputFactory.newInstance()
    }

    override fun calculate(initialInput: String?): Int {
        rawInput.initialize()
        val input = initialInput ?: return rawInput.getResultIntOrZero(true)
        val trimmedInput = input.replace(" ", "")
        trimmedInput.forEach { char ->
            if (isReadyToCalculate(char, rawInput)) {
                val result = rawInput.getResult(true)
                rawInput.initialize()
                rawInput.setFirstInput(result)
                rawInput.setOperator(Operator.toOperator(char))
            } else {
                rawInput.append(char)
            }
        }

        return rawInput.getResultIntOrZero(true)
    }

    private fun isReadyToCalculate(
        char: Char?,
        rawInput: OperationInput,
    ): Boolean {
        return Operator.isOperator(char) && rawInput.isReady()
    }
}
