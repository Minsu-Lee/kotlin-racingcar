package racing.view.result

object ResultFactory {
    private const val DEFAULT_MOVE_SYMBOL = '-'

    fun newInstance(moveSymbol: Char = DEFAULT_MOVE_SYMBOL): ResultView {
        return ResultViewImpl(moveSymbol)
    }
}
