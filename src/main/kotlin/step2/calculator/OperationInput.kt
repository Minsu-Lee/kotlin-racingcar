package step2.calculator

sealed class OperationInput {
    abstract val firstInput: String?
    abstract val secondInput: String?
    abstract val operator: Operator?

    abstract fun initialize()

    abstract fun isReady(): Boolean

    abstract fun append(input: Char)

    abstract fun setFirstInput(input: String)

    abstract fun setSecondInput(input: String)

    abstract fun setOperator(operator: Operator)

    abstract fun set(
        firstInput: String,
        secondInput: String,
        operator: Operator,
    )

    abstract fun getResult(): String

    abstract fun getResultIntOrZero(): Int

    abstract fun ensureValidCalculation()

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

    private class OperationInputImpl(
        firstInput: String?,
        secondInput: String?,
        operator: Operator?,
    ) : OperationInput() {
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

        override fun getResult(): String {
            ensureValidCalculation()
            val arg1 = _firstInput?.toIntOrNull() ?: 0
            val arg2 = _secondInput?.toIntOrNull() ?: 0

            val result =
                when (_operator!!) {
                    Operator.PLUS -> arg1.plus(arg2)
                    Operator.MINUS -> arg1.minus(arg2)
                    Operator.TIMES -> arg1.times(arg2)
                    Operator.DIV -> arg1.div(arg2)
                }

            return "$result"
        }

        override fun getResultIntOrZero(): Int {
            return getResult().toIntOrNull() ?: 0
        }

        override fun ensureValidCalculation() {
            ensureValidInputs(_firstInput, _secondInput, _operator)
            ensureValidInputs(_firstInput, _secondInput)
            ensureSafeDivision(_secondInput)
        }

        private fun ensureValidInputs(
            firstInput: String?,
            secondInput: String?,
            operator: Operator?,
        ) {
            if (!validateInputs(firstInput, secondInput, operator)) {
                throw IllegalArgumentException("계산식이 입력되지 않았습니다.")
            }
        }

        private fun ensureValidInputs(
            firstInput: String?,
            secondInput: String?,
        ) {
            if (!validateInputs(firstInput, secondInput)) {
                throw IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.")
            }
        }

        private fun ensureSafeDivision(secondInput: String?) {
            if (isReady() && secondInput?.toIntOrNull() == 0) {
                throw ArithmeticException("분모는 0이 될 수 없습니다.")
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
    }
}
