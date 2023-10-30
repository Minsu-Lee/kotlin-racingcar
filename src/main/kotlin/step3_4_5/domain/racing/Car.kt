package step3_4_5.domain.racing

class Car(
    val carName: String,
    private var step: Int = DEFAULT_VALUE,
    private val randomNumberGenerator: NumberGenerator = RandomNumberGenerator
) {

    init {
        checkValidate(carName)
    }

    private fun checkValidate(carName: String) {
        require(carName.isNotBlank()) { error(PLEASE_ENTER_THE_NAME) }
        require(carName.length <= CAR_NAME_MAXIMUM_LENGTH) { CAR_NAME_CAN_NOT_EXCEED_MAXIMUM_LENGTH }
    }

    fun moveForward() {
        if (canGo(randomNumberGenerator.generateNumber())) step += ONE_STEP
    }

    fun currentStep(): Int = step

    private fun canGo(randomNumber: Int): Boolean {
        return randomNumber >= CAN_GO_NUMBER
    }

    companion object {
        private const val CAR_NAME_MAXIMUM_LENGTH = 5
        private const val CAR_NAME_CAN_NOT_EXCEED_MAXIMUM_LENGTH = "이름을 5자 이상 초과할 수 없어요."
        private const val PLEASE_ENTER_THE_NAME = "이름을 제대로 입력해 주세요."

        private const val DEFAULT_VALUE = 0
        private const val ONE_STEP = 1
        private const val CAN_GO_NUMBER = 4
    }
}
