package calculator

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `커스텀 구분자 사용`() {
        assertSimpleTest {
            run("//;\\n1;2;3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `음수를 포함해도 정상적으로 덧셈된다`() {
        assertSimpleTest {
            run("-1,2,3")
            assertThat(output()).contains("결과 : 4")
        }
    }

    @Test
    fun `일반 입력 테스트`() {
        assertSimpleTest {
            run("1,2,3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `에러 입력 테스트`() {
        assertSimpleTest {
            run("1,,3")
            assertThat(output()).contains("Invalid input")
        }
    }

    @Test
    fun `커스텀 구분자를 특수문자로 지정`() {
        assertSimpleTest {
            run("//+\\n1,2+3")
            assertThat(output()).contains("결과 : 6")
        }
    }

    @Test
    fun `커스텀 구분자 형식 틀릴 경우 예외 발생`() {
        assertSimpleTest {
            run("//\n1,3")
            assertThat(output()).contains("Invalid input")
        }
    }

        override fun runMain() {
        main()
    }
}
