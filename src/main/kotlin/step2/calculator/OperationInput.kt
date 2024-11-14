package step2.calculator

interface OperationInput {
    val firstInput: String?
    val secondInput: String?
    val operator: Operator?

    fun initialize()

    fun isReady(): Boolean

    fun append(input: Char)

    fun setFirstInput(input: String)

    fun setSecondInput(input: String)

    fun setOperator(operator: Operator)

    fun set(
        firstInput: String,
        secondInput: String,
        operator: Operator,
    )

    fun getResult(isInvalid: Boolean = false): String

    fun getResultIntOrZero(isInvalid: Boolean): Int

    fun ensureValidCalculation()

    companion object {
        fun newInstance(
            firstInput: String? = null,
            secondInput: String? = null,
            operator: Operator? = null,
        ): OperationInput {
            return OperationInputImpl(
                firstInput,
                secondInput,
                operator,
            )
        }
    }
}

private class OperationInputImpl(
    firstInput: String?,
    secondInput: String?,
    operator: Operator?,
) : OperationInput {
    private var _firstInput: String? = firstInput
    private var _secondInput: String? = secondInput
    private var _operator: Operator? = operator

    override val firstInput: String?
        get() = _firstInput

    override val secondInput: String?
        get() = _secondInput

    override val operator: Operator?
        get() = _operator

    override fun initialize() {
        _firstInput = null
        _secondInput = null
        _operator = null
    }

    override fun isReady(): Boolean {
        return !_firstInput.isNullOrEmpty() && !_secondInput.isNullOrEmpty() && _operator != null
    }

    override fun append(input: Char) {
        when {
            !input.isDigit() -> _operator = Operator.toOperator(input)
            _operator == null && _secondInput.isNullOrEmpty() -> _firstInput = (_firstInput ?: "") + input
            _operator != null -> _secondInput = (_secondInput ?: "") + input
        }
    }

    override fun setFirstInput(input: String) {
        this._firstInput = input
    }

    override fun setSecondInput(input: String) {
        this._secondInput = input
    }

    override fun setOperator(operator: Operator) {
        this._operator = operator
    }

    override fun set(
        firstInput: String,
        secondInput: String,
        operator: Operator,
    ) {
        this._firstInput = firstInput
        this._secondInput = secondInput
        this._operator = operator
    }

    override fun getResult(isInvalid: Boolean): String {
        if (isInvalid) {
            ensureValidCalculation()
        }

        val arg1 = _firstInput!!.toInt()
        val arg2 = _secondInput!!.toInt()

        val result =
            when (_operator) {
                Operator.PLUS -> arg1.plus(arg2)
                Operator.MINUS -> arg1.minus(arg2)
                Operator.TIMES -> arg1.times(arg2)
                else -> arg1.div(arg2)
            }

        return "$result"
    }

    override fun getResultIntOrZero(isInvalid: Boolean): Int {
        return getResult(isInvalid).toIntOrNull() ?: 0
    }

    override fun ensureValidCalculation() {
        when {
            !validateInputs(_firstInput, _secondInput, _operator) -> {
                throw IllegalArgumentException("계산식이 입력되지 않았습니다.")
            }

            !validateInputs(_firstInput, _secondInput) -> {
                throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
            }

            !validateOperator(_operator) -> {
                throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }

    private fun validateInputs(
        firstInput: String?,
        secondInput: String?,
        operator: Operator?,
    ): Boolean {
        val isInputInvalid = firstInput.isNullOrEmpty() && secondInput.isNullOrEmpty()
        val isOperatorInvalid = !Operator.isOperator(operator)
        return !(isInputInvalid && isOperatorInvalid)
    }

    private fun validateInputs(
        firstInput: String?,
        secondInput: String?,
    ): Boolean {
        return !(firstInput.isNullOrEmpty() || secondInput.isNullOrEmpty())
    }

    private fun validateOperator(operator: Operator?): Boolean {
        return Operator.isOperator(operator)
    }
}
