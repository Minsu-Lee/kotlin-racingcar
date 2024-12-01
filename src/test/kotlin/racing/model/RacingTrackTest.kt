package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTrackTest {
    @ParameterizedTest
    @ValueSource(strings = ["aa, bb, cc, dd", "aaa, bbb, ccc", "a, b, c"])
    fun `우승자가 없는 경우 테스트`(input: String) {
        val carNames = input.split(",").map { it.trim() }
        val cars = CarFactory.createCars(carNames) { IntRangeEngineFactory.create(0..3) }
        RacingTrack(cars, 1).startRound()
        val winners = WinnerDecider.decideWinners(cars)
        assertThat(winners.size)
            .isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["aa, bb, cc, dd", "aaa, bbb, ccc", "a, b, c"])
    fun `참여 자동차가 모두 우승한 경우 테스트`(input: String) {
        val carNames = input.split(",").map { it.trim() }
        val cars = CarFactory.createCars(carNames) { IntRangeEngineFactory.create(4..9) }
        RacingTrack(cars, 1).startRound()
        val winners = WinnerDecider.decideWinners(cars)
        assertThat(winners.size)
            .isEqualTo(carNames.size)
    }
}
