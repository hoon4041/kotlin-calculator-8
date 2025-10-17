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



        override fun runMain() {
        main()
    }
}
