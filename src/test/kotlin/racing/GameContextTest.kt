package racing

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.view.input.ConsoleInputViewFactory
import racing.view.result.ConsoleResultViewFactory

class GameContextTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "aaa,bbb,ccc",
            "aaa,bbb,ccc,ddd",
            "aaa,bbb,ccc,ddd,eee"
        ]
    )
    fun `입력 받은 자동차 이름 개수만큼 Car 객체 리스트를 생성한다`(input: String) {
        val inputView = ConsoleInputViewFactory.newInstance()
        val resultView = ConsoleResultViewFactory.newInstance()
        val gameContext = GameContext(inputView, resultView)
        val carNames = input.split(",")
        val carList = gameContext.createCars(carNames)
        carNames.size shouldBe carList.size
        carNames.forEachIndexed { index, name ->
            carList[index].name shouldBe name
        }
    }
}
