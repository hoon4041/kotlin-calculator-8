package calculator

class InputParser {

    fun parse(input: String): List<Int> {
        if(input.isEmpty()) {
            return emptyList()
        }

        val subInput: String
        val regexPattern: String

        if (input.startsWith("//") && input.length > 4 && input[3] == '\\' && input[4] == 'n') { // 커스텀 구분자가 있는 경우
            val customSeparator = input[2]

            if(customSeparator == '-' || customSeparator.isDigit()) {
                throw IllegalArgumentException("Invalid custom separator(can't use '-' or number")
            }
            val escapedSeparator = Regex.escape(customSeparator.toString()) // 이게 있어야 특수문자 입력 가능
            subInput = input.substring(5)
            regexPattern = "[,:]|$escapedSeparator"
        } else { // 커스텀 구분자가 없는 경우
            subInput = input
            regexPattern = "[,:]"
        }
        val parts = subInput.split(Regex(regexPattern))

        val numbers = try {
            parts.map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input")
        }
        // 음수 검증 로직 추가
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) {
            throw IllegalArgumentException("Negative numbers are not supported")
        }

        return numbers
    }
}