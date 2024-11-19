package study.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.racing.view.input.InputViewFactory

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["    ", "q2", "1 1", "33-3", "  1"])
    fun `숫자 입력값 검증 테스트`(input: String) {
        val inputView = InputViewFactory.newInstance()
        shouldThrow<IllegalArgumentException> {
            inputView.inputNumber(input)
        }.apply {
            message shouldBe "숫자를 입력해주세요."
        }
    }

    @Test
    fun `숫자 입력값 검증 테스트 2`() {
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
