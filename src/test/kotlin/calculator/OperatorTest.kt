package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {
    @ParameterizedTest
    @ValueSource(chars = ['+', '-', '*', '/'])
    fun `연산자 파라메터 테스트`(char: Char) {
        assertTrue(Operator.isOperator(char))
    }

    @ParameterizedTest
    @ValueSource(chars = [' ', '%', '#', '@'])
    fun `연산자 파라메터 테스트2`(char: Char) {
        assertFalse(Operator.isOperator(char))
    }

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
}
