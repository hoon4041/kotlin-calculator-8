package calculator

import camp.nextstep.edu.missionutils.Console


object Processor {

    val inputParser = InputParser()
    val calculator = Calculator()

    fun run() {
        println("덧셈할 문자열을 입력해 주세요.")
        val input = Console.readLine()
        val numbers = inputParser.parse(input)

        val sum = calculator.add(numbers)
        println("결과 : $sum")
    }
}