package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    private val parser = InputParser()

    @Test
    fun `연속된 구분자 입력 시 IllegalArgumentException 발생`() {
        val input = "1,,3"

        assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }
    }

    @Test
    fun `커스텀 구분자를 특수문자로 지정`() {
        val input = "//+\\n1,2+3"
        val result = parser.parse(input)

        assertThat(result).isEqualTo(listOf<Int>(1,2,3))
    }

    @Test
    fun `커스텀 구분자 형식 틀릴 경우 예외 발생`() {
        val input = "//\\n1,3"

        assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }
    }

    @Test
    fun `아무것도 입력 안할시 빈 리스트 반환`() {
        val input = ""
        val result = parser.parse(input)
        assertThat(result).isEmpty()
    }

}