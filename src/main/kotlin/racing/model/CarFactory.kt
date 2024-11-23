package racing.model

object CarFactory {
    fun createCars(
        carNames: List<String>,
        engineProvider: () -> Engine,
    ): List<Car> {
        val engine = engineProvider()
        return carNames.map { Car(it, engine) }
    }
}
