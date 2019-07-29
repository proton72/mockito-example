import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.contains
import com.natpryce.hamkrest.equalTo
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test

class HammerTest {

    @Test
    fun basicTest() {
        val hammerMock: Hammer = mock()
        hammerMock.size = 7

        verify(hammerMock).size = 7
    }

    @Test
    fun basicUsefulTest() {
        val parametersMock: Parameters = mock()
        val hammerReal = Hammer(parametersMock)
        hammerReal.size = 7

        verify(parametersMock).size = 8

       assertThat("дефолтное значение 0", hammerReal.weight, equalTo(0))
}

    @Test
    fun spyTest() {
        val realHammer = Hammer()
        val hSize = 10
        realHammer.size = hSize
        val hammerSpy: Hammer = spy(realHammer)

        val realResult = hammerSpy.giveOtherPeople(Nail(88))
        assertThat(realResult, contains("Ударь плз молотком размера ${hSize + 1} и веса 5 по предмету ".toRegex()))

        whenever(hammerSpy.giveOtherPeople(Nail(88))) doReturn "Попросили кикнуть по Nail размера 88 "

        val fakeResult = hammerSpy.giveOtherPeople(Nail(88))
        assertThat(fakeResult, contains("Попросили кикнуть по Nail размера 88".toRegex()))
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