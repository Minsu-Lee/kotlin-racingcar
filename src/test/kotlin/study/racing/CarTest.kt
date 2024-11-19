package study.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step3.racing.model.car.Car
import step3.racing.model.generator.RandomGeneratorFactory

class CarTest {
    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4미만인 경우 멈춘다`() {
        val numberGenerator = RandomGeneratorFactory.newInstance(0..3)
        val car = Car(numberGenerator = numberGenerator)
        car.move()
        car.position shouldBe 0
    }

    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다`() {
        val numberGenerator = RandomGeneratorFactory.newInstance(4..9)
        val car = Car(numberGenerator = numberGenerator)
        car.move()
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
        val car = Car(numberGenerator = numberGenerator)
        car.move()
        car.position shouldBe 0
    }

    @ParameterizedTest
    @CsvSource("4, 5", "4, 9", "5, 8")
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다2`(
        randomMin: Int,
        randomMax: Int,
    ) {
        val numberGenerator = RandomGeneratorFactory.newInstance(randomMin..randomMax)
        val car = Car(numberGenerator = numberGenerator)
        car.move()
        car.position shouldBe 1
    }

    @ParameterizedTest
    @CsvSource("4, 5", "4, 9", "5, 8")
    fun `사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다`(
        carCount: Int,
        attemptCount: Int,
    ) {
        val car = Car()
        car.carCount = carCount
        car.carCount shouldBe carCount
        car.attemptCount = attemptCount
        car.attemptCount shouldBe attemptCount
    }

    @Test
    fun `자동차 대수는 최소 입력 테스트`() {
        val car = Car()
        shouldThrow<IllegalArgumentException> {
            car.carCount = 0
            car.move()
        }.apply {
            message shouldBe "자동차 대수는 최소 1대 이상이어야 합니다."
        }

        shouldThrow<IllegalArgumentException> {
            car.carCount = 1
            car.attemptCount = 0
            car.move()
        }.apply {
            message shouldBe "시도 횟수는 최소 1번 이상이어야 합니다."
        }
    }
}
