package racing.controller

import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.view.input.MockInputViewImpl
import racing.view.result.MockResultView

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
        val inputView = MockInputViewImpl(
            rawCarNameInput = input,
            rawAttemptCountInput = "45"
        )
        val resultView = MockResultView(
            displayRaceWinnersBlock = { winners ->
                winners.size shouldBeGreaterThanOrEqual 1
            }
        )
        val controller = RacingControllerFactory.newInstance(inputView, resultView)
        controller.start()
    }
}
