package racing.controller

import racing.service.generator.NumberGenerator

object MockRandomGeneratorFactory {
    fun newInstance(fixedValue: Int): NumberGenerator {
        return object : NumberGenerator {
            override fun generator(): Int = fixedValue
        }
    }

    fun newInstance(range: IntRange): NumberGenerator {
        return object : NumberGenerator {
            override fun generator(): Int = range.random()
        }
    }
}
