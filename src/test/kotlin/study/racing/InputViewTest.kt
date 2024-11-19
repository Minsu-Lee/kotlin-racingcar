package study.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import step3.racing.view.input.InputViewFactory

class InputViewTest {
    @Test
    fun `숫자 입력값 검증 테스트`() {
        val inputView = InputViewFactory.newInstance()
        var carCountStr: String? = ""

        var exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }
        assert(
            exception.message == "입력값을 확인해주세요.",
        )

        carCountStr = null
        exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }

        assert(exception.message == "입력값을 확인해주세요.")

        carCountStr = "="
        exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }
        assert(exception.message == "숫자를 입력해주세요.")

        carCountStr = "1 2"
        exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }
        assert(exception.message == "숫자를 입력해주세요.")

        carCountStr = "0"
        exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }
        assert(exception.message == "최소 0보다 큰수를 입력해주세요.")

        carCountStr = "-5"
        exception =
            assertThrows<IllegalArgumentException> {
                inputView.inputNumber(carCountStr)
            }
        assert(exception.message == "최소 0보다 큰수를 입력해주세요.")

        carCountStr = "10"
        assertThat(inputView.inputNumber(carCountStr))
            .isGreaterThan(0)

        assertThat(inputView.inputNumber(carCountStr))
            .isEqualTo(10)
    }
}
