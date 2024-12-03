package racing

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.view.input.MockInputView
import racing.view.result.MockResultView

class GameContextTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "aaa,bbb,ccc",
            "aaa,bbb,ccc,ddd",
            "aaa,bbb,ccc,ddd,eee",
        ],
    )
    fun `입력 받은 자동차 이름 개수만큼 Car 객체 리스트를 생성한다`(input: String) {
        val inputView = MockInputView(input.split(","), 1)
        val resultView = MockResultView()
        val gameContext = GameContext(inputView, resultView)
        val carNames = inputView.inputCarNames()
        val cars = gameContext.createCars(carNames)
        carNames.size shouldBe cars.size
        carNames.forEachIndexed { index, name ->
            cars[index].name shouldBe name
        }
    }
}
