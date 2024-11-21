package racing.service.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GeneratorTest {
    @ParameterizedTest
    @CsvSource("0, 9", "4, 5", "7, 8", "8, 8", "1, 2")
    fun `지정한 범위 내, 난수를 만들 수 있다`(
        randomMin: Int,
        randomMax: Int,
    ) {
        val randomRange = randomMin..randomMax
        val randomNumber =
            RandomGeneratorFactory.newInstance(
                randomRange,
            ).generator()

        assertThat(randomNumber)
            .isLessThanOrEqualTo(randomNumber)

        assertThat(randomNumber)
            .isGreaterThanOrEqualTo(randomMin)
    }
}
