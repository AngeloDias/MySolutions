package tests

import io.mockk.MockKAnnotations
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import solutions.CheckIfTheLettersAreJumbled

class CheckIfTheLettersAreJumbledTest {

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun isOneStringPartialPermutationTest() {
        assertTrue(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation("you", "yuo")
        )
        assertTrue(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation("probably", "porbalby")
        )
        assertTrue(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation("despite", "desptie")
        )

        assertTrue(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation(
                                "despite despite",
                                "desptie despite")
        )

        // False
        assertFalse(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation("moon", "nmoo")
        )
        assertFalse(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation("misspellings", "mpeissngslli")
        )
        assertFalse(
                CheckIfTheLettersAreJumbled
                        .isOneStringPartialPermutation(
                                "misspellings",
                                "mpeissngsllings")
        )

    }

}
