package calculator

class InputParser {

    val validater = Validater()

    fun parse(input: String): List<Int> {
        val isValid = validater.validate(input)
        if(!isValid) { throw IllegalArgumentException("Invalid input")}

        if (input[0].isDigit()) {  // 커스텀 구분자 없이 바로 숫자가 나오는 경우
            val parts = input.split(Regex("[,:]"))
            return parts.map { it.trim().toInt() }
        } else if (input.startsWith("/") && input[1] == '/' && input[3] == '\\' && input[4] == 'n') { // 커스텀 구분자가 있는 경우
            val customSeparator = input[2]
            val subInput = input.substring(5)
            val parts = subInput.split(Regex("[,:${customSeparator}]"))
            return parts.map { it.trim().toInt() }
        }
        throw IllegalArgumentException("something wrong, warning!!!")
    }
}