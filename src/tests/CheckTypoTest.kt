package tests

import io.mockk.MockKAnnotations
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import solutions.CheckTypo

class CheckTypoTest {

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun isZeroOrOneTypoTest() {
        assertTrue(CheckTypo.isZeroOrOneTypo("pale", "ple"))
        assertTrue(CheckTypo.isZeroOrOneTypo("pale", "pales"))
        assertTrue(CheckTypo.isZeroOrOneTypo("pales", "pales"))
        assertTrue(CheckTypo.isZeroOrOneTypo("p", "p"))
        assertTrue(CheckTypo.isZeroOrOneTypo("p", "a"))

        assertFalse(CheckTypo.isZeroOrOneTypo("pales", "bakes"))
        assertFalse(CheckTypo.isZeroOrOneTypo("pake", "bales"))
        assertFalse(CheckTypo.isZeroOrOneTypo("pak", "bales"))
        assertFalse(CheckTypo.isZeroOrOneTypo("paks", "bales"))
        assertFalse(CheckTypo.isZeroOrOneTypo("ap", "pa"))
    }

}
