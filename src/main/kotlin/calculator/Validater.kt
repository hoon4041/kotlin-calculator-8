package calculator

class Validater {


    fun validate(input: String): Boolean {
        if(input.isEmpty()) {
            return false
        } else if(input[0].isDigit()) {  // 커스텀 구분자 없이 바로 숫자가 나오는 경우
            val parts = input.split(Regex("[,:]"))
            val isValid = parts.all { it.toIntOrNull() != null && it.isNotEmpty() }
            if(!isValid) {
                return false
            }
            return true
        } else if(input.startsWith("/") && input[1] == '/' && input[3] == '\\' && input[4] == 'n') { // 커스텀 구분자가 있는 경우

            val customSeparator = input[2]
            val subInput = input.substring(5)
            val parts = subInput.split(Regex("[,:${customSeparator}]"))
            val isValid = parts.all { it.toIntOrNull() != null && it.isNotEmpty() }
            if(!isValid) {
                return false
            }
            return true
        }
        return false
    }
}