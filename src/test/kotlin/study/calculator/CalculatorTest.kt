package study.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import step2.calculator.Calculator

class CalculatorTest {
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

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                calculator.calculate("")
            }
            .withMessage("계산식이 입력되지 않았습니다.")
            .withNoCause()

        assertThatExceptionOfType(ArithmeticException::class.java)
            .isThrownBy {
                calculator.calculate("10 / 0")
            }
            .withMessage("분모는 0이 될 수 없습니다.")
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
