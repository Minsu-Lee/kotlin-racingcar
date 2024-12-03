package racing.model

class Cars(val carList: List<Car>): List<Car> by carList {
    fun moveAll() {
        carList.forEach {
            it.move()
        }
    }

    fun getRaceWinners(): Cars {
        val validCars = carList.filter { it.position > 0 }
        val groupedByPosition = validCars.groupBy { it.position }
        val maxPosition = groupedByPosition.keys.maxOrNull()
        val carList = groupedByPosition[maxPosition] ?: emptyList()
        return Cars(carList)
    }
}