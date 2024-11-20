package study.racing.model.car

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.model.car.Car
import racing.model.generator.RandomGeneratorFactory

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
}
