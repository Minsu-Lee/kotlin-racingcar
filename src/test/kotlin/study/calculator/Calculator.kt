package study.calculator

interface Calculator {
    fun calculate(input: String?): Int

    companion object {
        fun newInstance(): Calculator {
            return CalculatorImpl()
        }
    }
}

private class CalculatorImpl : Calculator {
    private val rawInput: OperationInput by lazy {
        OperationInput.newInstance()
    }

    override fun calculate(input: String?): Int {
        rawInput.initialize()
        val trimmedInput = input?.replace(" ", "")

        trimmedInput?.forEach { char ->
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
