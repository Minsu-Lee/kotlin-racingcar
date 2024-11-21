package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import calculator.OperationInputFactory
import calculator.Operator

class OperatorInputTest {
    @Test
    fun `데이터 초기화 테스트`() {
        val operator = Operator.toOperator('+')
        val data = OperationInputFactory.newInstance(firstInput = "123", secondInput = "3123", operator = operator)

        data.initialize()
        assertThat(data.firstInput).isNull()
        assertThat(data.operator).isNull()
        assertThat(data.secondInput).isNull()
    }

    @Test
    fun `데이터 준비 상태 테스트`() {
        val operator = Operator.toOperator('+')
        val data = OperationInputFactory.newInstance(firstInput = "123", secondInput = "3123", operator = operator)
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
        val data = OperationInputFactory.newInstance()
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
    fun `데이터 입력 테스트2`() {
        val data = OperationInputFactory.newInstance()
        data.append('1')
        data.append('2')
        data.append('+')
        val operator = Operator.toOperator('+')
        assertThat(data.operator).isEqualTo(operator)
    }

    @Test
    fun `데이터 입력 테스트3`() {
        val data = OperationInputFactory.newInstance()
        val expression = "12+3"
        expression.forEach(data::append)
        assertThat(data.isReady())
            .isTrue()
    }

    @Test
    fun `데이터 입력 테스트4`() {
        val data = OperationInputFactory.newInstance()
        val expression = "123"
        expression.forEach(data::append)
        assertThat(data.isReady())
            .isFalse()
    }
}
