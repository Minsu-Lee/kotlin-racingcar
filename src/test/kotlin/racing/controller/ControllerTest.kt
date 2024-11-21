package racing.controller

import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ControllerTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "CarA, CarB, CarC",
            "CarA, CarB, CarC, CarD",
            "CarA, CarB, CarC, CarD, CarE",
        ],
    )
    fun `자동차 경주가 시작되면 1명 이상의 우승자가 결정된다`(input: String) {
        val inputView =
            object : MockInputView {
                override fun inputNumber(input: String?): Int {
                    return 4
                }

                override fun inputCarNames(input: String?): List<String> {
                    return input?.split(",")?.map { it.trim() } ?: listOf()
                }
            }
        val resultView = object : MockResultView {}
        val numberGenerator = MockRandomGeneratorFactory.newInstance(0..9)
        val controller = RacingControllerFactory.newInstance(inputView, resultView, numberGenerator)

        val carNames = inputView.inputCarNames(input)
        val attemptCount = inputView.inputNumber("")

        with(controller) {
            val cars = getCarList(carNames)

            repeat(attemptCount) {
                startRound(cars)
            }

            val winners = getRaceWinners(cars)
            winners.size shouldBeGreaterThanOrEqual 1
        }
    }
}
