package step4

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.InputSupplier
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.presentation.RacingGameInputView
import java.lang.IllegalArgumentException

class RacingGameInputViewTest {
    @Test
    fun `차 이름들을 적으면 리스트로 뽑아준다`() {
        val testInputSupplier1 = object : InputSupplier {
            override fun read(): String {
                return "kot,pyt,java"
            }
        }

        assertThat(RacingGameInputView(testInputSupplier1).enterCars()).isEqualTo(
            RacingCars(
                listOf(
                    RacingCar(CarName(name = "kot")),
                    RacingCar(CarName(name = "pyt")),
                    RacingCar(CarName(name = "java"))
                )
            )
        )
    }

    @Test
    fun `차 이름들 중 하나라도 5자를 초과하면 예외를 던진다`() {
        val testInputSupplier = object : InputSupplier {
            override fun read(): String {
                return "kotlin,python,java"
            }
        }

        Assertions.assertThatThrownBy { RacingGameInputView(testInputSupplier).enterCars() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
