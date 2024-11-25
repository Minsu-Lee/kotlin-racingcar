package racing.model

object WinnerDecider {
    fun decideWinners(cars: List<Car>): List<Car> {
        val validCars = cars.filter { it.position > 0 }
        val groupedByPosition = validCars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        return groupedByPosition[maxPosition] ?: emptyList()
    }
}
