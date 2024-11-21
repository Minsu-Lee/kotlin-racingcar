package racing.view.input

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["    ", "q2", "1 1", "33-3", "  1"])
    fun `숫자 입력값 검증 테스트`(input: String) {
        val inputView = ConsoleInputViewFactory.newInstance()
        shouldThrow<IllegalArgumentException> {
            inputView.inputNumber(input)
        }.apply {
            message shouldBe "숫자를 입력해주세요."
        }
    }

    @Test
    fun `숫자 입력값 검증 테스트 2`() {
        val inputView = ConsoleInputViewFactory.newInstance()
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

    @ParameterizedTest
    @ValueSource(strings = ["pobi231123", "crong~~", "hondux", "민수르수르르", "수민수민수민수", "스르스르스스스"])
    fun `자동차 이름 5자 이내 입력 태스트`(carName: String) {
        val inputView = ConsoleInputViewFactory.newInstance()
        shouldThrow<IllegalArgumentException> {
            inputView.inputCarNames(carName)
        }.apply {
            message shouldBe "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["민수", "수민", "수박", "pobi", "crong", "honux"])
    fun `자동차 이름 5자 초과 입력 테스트`(carName: String) {
        val inputView = ConsoleInputViewFactory.newInstance()
        shouldNotThrow<IllegalArgumentException> {
            inputView.inputCarNames(carName)
        }
    }
}
