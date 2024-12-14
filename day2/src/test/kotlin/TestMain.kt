import org.example.isSafeDampenedReport
import kotlin.test.Test

class TestMain {
    @Test
    fun `is Dampened safe report test`() {
        val report = "2 4 6 2 7".split(" ").map { it.toInt() }
        assert(report.isSafeDampenedReport())
    }
}