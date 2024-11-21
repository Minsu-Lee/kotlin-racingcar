package racing.model.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.InvalidCarNameException
import racing.service.generator.RandomGeneratorFactory

class CarTest {
    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4미만인 경우 멈춘다`() {
        val numberGenerator = RandomGeneratorFactory.newInstance(0..3)
        val car = Car()
        car.move(numberGenerator = numberGenerator)
        car.position shouldBe 0
    }

    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다`() {
        val numberGenerator = RandomGeneratorFactory.newInstance(4..9)
        val car = Car()
        car.move(numberGenerator = numberGenerator)
        car.position shouldBe 1
    }

    @ParameterizedTest
    @CsvSource("0, 3", "0, 1", "2, 3")
    fun `주어진 횟수 동안 n대의 자동차는 4미만인 경우 멈춘다 2`(
        randomMin: Int,
        randomMax: Int,
    ) {
        val numberGenerator =
            RandomGeneratorFactory.newInstance(
                randomMin..randomMax,
            )
        val car = Car()
        car.move(numberGenerator = numberGenerator)
        car.position shouldBe 0
    }

    @ParameterizedTest
    @CsvSource("4, 5", "4, 9", "5, 8")
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다2`(
        randomMin: Int,
        randomMax: Int,
    ) {
        val numberGenerator = RandomGeneratorFactory.newInstance(randomMin..randomMax)
        val car = Car()
        car.move(numberGenerator = numberGenerator)
        car.position shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(strings = ["이민수", "이창환", "json", "minsu"])
    fun `각 자동차에 이름을 부여할 수 있다`(name: String) {
        val car = Car(name = name)
        car.name shouldBe name
    }

    @ParameterizedTest
    @ValueSource(strings = ["이민수루루루", "이창환느느느~", "jsonnnn~", "jacksons~"])
    fun `자동차 이름은 5자를 초과할 수 없다`(name: String) {
        shouldThrow<InvalidCarNameException> {
            Car(name = name)
        }.apply {
            message shouldBe "자동차의 이름은 5자를 초과할 수 없습니다."
        }
    }
}
