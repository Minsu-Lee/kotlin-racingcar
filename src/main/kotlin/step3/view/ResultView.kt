package step3.view

sealed interface ResultView {
    fun printOutputTitle()

    fun displayCarMovement(
        carMoveCounts: Array<Int>,
        carIndex: Int,
        moveSymbol: Char,
    )

    fun displayCarMovement(
        moveCounts: Array<Array<Int>>,
        carCount: Int,
        attemptCount: Int,
        moveSymbol: Char,
    )
}

object ResultViewFactroy {
    fun newInstance(): ResultView {
        return ResultViewImpl()
    }
}

private class ResultViewImpl : ResultView {
    override fun printOutputTitle() {
        println("실행결과")
    }

    override fun displayCarMovement(
        carMoveCounts: Array<Int>,
        carIndex: Int,
        moveSymbol: Char,
    ) {
        val carMoveCount = carMoveCounts[carIndex]
        repeat(carMoveCount) {
            print(moveSymbol)
        }
        println()
    }

    override fun displayCarMovement(
        moveCounts: Array<Array<Int>>,
        carCount: Int,
        attemptCount: Int,
        moveSymbol: Char,
    ) {
        repeat(attemptCount) { attemptIndex ->
            repeat(carCount) { carIndex ->

                val forwardNumber =
                    moveCounts[carIndex]
                        .slice(0..attemptIndex)
                        .sum()

                repeat((0 until forwardNumber).count()) {
                    print(moveSymbol)
                }
                println()
            }
            println()
        }
    }
}
