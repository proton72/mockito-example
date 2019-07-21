import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.contains
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test

class HammerTest {

    @Test
    fun basicTest() {
        val hammerMock: Hammer = mock()
        hammerMock.size = 7

        verify(hammerMock).size = 7
    }

    @Test
    fun spyTest() {
        val realHammer = Hammer()
        realHammer.size = 10
        val hammerSpy: Hammer = spy(realHammer)

        val realResult = hammerSpy.giveOtherPeople(Nail(88))
        assertThat(realResult, contains("Ударь плз молотком размера 10 по предмету".toRegex()))
    }

    @Test
    fun argumentCaptorTest() {
        val captorNail = argumentCaptor<Nail>()
        val hammerMock: Hammer = mock()

        hammerMock.kick(Nail(42))
        verify(hammerMock).kick(captorNail.capture())

        assertThat(captorNail.firstValue.height, equalTo(42))
    }
}