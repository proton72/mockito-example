import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test

class HammerTest {

    @Test
    fun basicTest() {
        val hammerMock: Hammer = mock()

        hammerMock.kick(Nail(42))
        hammerMock.size = 7

        verify(hammerMock).size = 7
    }
}