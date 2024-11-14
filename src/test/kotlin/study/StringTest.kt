package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import step2.calculator.Calculator
import step2.calculator.OperationInput
import step2.calculator.Operator

/**
 * 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
class StringTest {
    @Test
    fun `연산자 체크`() {
        assertThat("+-*/".toList()).allSatisfy {
            assertThat(Operator.isOperator(it))
                .isTrue()
        }

        assertThat(Operator.isOperator(' '))
            .isFalse()

        assertThat(Operator.isOperator('='))
            .isFalse()

        assertThat(Operator.isOperator('$'))
            .isFalse()

        assertThat(Operator.isOperator('*'))
            .isTrue()
    }

    @Test
    fun `데이터 초기화 테스트`() {
        val operator = Operator.toOperator('+')
        val data = OperationInput.newInstance(firstInput = "123", secondInput = "3123", operator = operator)

        data.initialize()
        assertThat(data.firstInput).isNull()
        assertThat(data.operator).isNull()
        assertThat(data.secondInput).isNull()
    }

    @Test
    fun `데이터 준비 상태 테스트`() {
        val operator = Operator.toOperator('+')
        val data = OperationInput.newInstance(firstInput = "123", secondInput = "3123", operator = operator)
        assertThat(data.isReady()).isTrue()

        data.initialize()

        data.setFirstInput("2313")
        assertThat(data.isReady()).isFalse()

        data.setSecondInput("1312312")
        assertThat(data.isReady()).isFalse()

        data.setOperator(Operator.toOperator('-'))
        assertThat(data.isReady()).isTrue()
    }

    @Test
    fun `데이터 입력 테스트`() {
        val data = OperationInput.newInstance()
        data.append('1')
        data.append('2')
        assertThat(data.firstInput).isEqualTo("12")

        data.append('+')
        val operator = Operator.toOperator('+')
        assertThat(data.operator).isEqualTo(operator)

        data.append('3')
        assertThat(data.secondInput).isEqualTo("3")

        val result = data.getResult()
        assertThat(result).isEqualTo("15")
    }

    @Test
    fun `덧셈`() {
        val calculator = Calculator.newInstance()
        assertThat(calculator.calculate("10+12"))
            .isEqualTo(22)

        assertThat(calculator.calculate("100+12"))
            .isEqualTo(112)

        assertThat(calculator.calculate("150+1050"))
            .isEqualTo(1200)
    }

    @Test
    fun `뺄셈`() {
        val result = Calculator.newInstance().calculate("10-12")
        assertThat(result).isEqualTo(-2)
    }

    @Test
    fun `나눗셈`() {
        val result = Calculator.newInstance().calculate("12/3")
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun `곱셈`() {
        val result = Calculator.newInstance().calculate("10*12")
        assertThat(result).isEqualTo(120)
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우`() {
        val calculator = Calculator.newInstance()
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate(" * 12")
            }
            .withMessage("입력값이 null이거나 빈 공백 문자입니다.")
            .withNoCause()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate(" * ")
            }
            .withMessage("입력값이 null이거나 빈 공백 문자입니다.")
            .withNoCause()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate("1 * ")
            }
            .withMessage("입력값이 null이거나 빈 공백 문자입니다.")
            .withNoCause()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate(null)
            }
            .withMessage("계산식이 입력되지 않았습니다.")
            .withNoCause()
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        val calculator = Calculator.newInstance()
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate("10 = 20")
            }
            .withMessage("사칙연산 기호가 아닙니다.")
            .withNoCause()

        val operations = listOf("10 + 20", "10 - 20", "10 * 20", "10 / 20")
        assertThat(operations).allSatisfy {
            val result = calculator.calculate(it)
            assertThat(result).isGreaterThanOrEqualTo(-10)
        }

        val result1 = calculator.calculate("10 + 20")
        assertThat(result1).isEqualTo(30)

        val result2 = calculator.calculate("10 - 20")
        assertThat(result2).isEqualTo(-10)

        val result3 = calculator.calculate("10 * 20")
        assertThat(result3).isEqualTo(200)

        val result4 = calculator.calculate("10 / 20")
        assertThat(result4).isEqualTo(0)
    }

    @Test
    fun `문자열 내 공백이 포함된 경우 테스트`() {
        val result = Calculator.newInstance().calculate("10 * 12")
        assertThat(result).isEqualTo(120)
    }
}
