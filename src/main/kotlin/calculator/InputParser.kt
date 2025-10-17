package calculator

class InputParser {

    fun parse(input: String): List<Int> {
        if(input.isEmpty()) {
            return emptyList()
        }
        if (input.startsWith("//") && input.length > 4 && input[3] == '\\' && input[4] == 'n') { // 커스텀 구분자가 있는 경우
            val customSeparator = input[2]
            val subInput = input.substring(5)
            val parts = subInput.split(Regex("[,:${customSeparator}]"))
            try {
                return parts.map { it.trim().toInt() }
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("Invalid input")
            }
        }
        // 커스텀 구분자 없는 경우
        val parts = input.split(Regex("[,:]"))
        try {
            return parts.map {it.trim().toInt()}
        } catch (e: NumberFormatException) { // 숫자가 아닌 다른 값이 입력으로 있을 경우 예외 발생
            throw IllegalArgumentException("Invalid input")
        }
    }
}