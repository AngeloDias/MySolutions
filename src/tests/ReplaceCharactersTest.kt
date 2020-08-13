package tests

import io.mockk.MockKAnnotations
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import solutions.ReplaceCharacters

class ReplaceCharactersTest {

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun replaceInPlaceTest() {
        var expectedStr = "User&32is&32not&32allowed".toCharArray().toTypedArray()
        var result = ReplaceCharacters
            .replaceInPlace("User is not allowed      ".toCharArray().toTypedArray(), 19)

        Assert.assertArrayEquals(expectedStr, result)

        expectedStr = "User&32is&32not&32&32allowed".toCharArray().toTypedArray()
        result = ReplaceCharacters
            .replaceInPlace("User is not  allowed        ".toCharArray().toTypedArray(), 20)

        Assert.assertArrayEquals(expectedStr, result)

        expectedStr = "User&32is&32not&32&32allowed&32".toCharArray().toTypedArray()
        result = ReplaceCharacters
            .replaceInPlace("User is not  allowed           ".toCharArray().toTypedArray(), 21)

        Assert.assertArrayEquals(expectedStr, result)

        expectedStr = "&32User&32is&32not&32&32allowed&32".toCharArray().toTypedArray()
        result = ReplaceCharacters
            .replaceInPlace(" User is not  allowed             ".toCharArray().toTypedArray(), 22)

        Assert.assertArrayEquals(expectedStr, result)

        expectedStr = "&32".toCharArray().toTypedArray()
        result = ReplaceCharacters
            .replaceInPlace("   ".toCharArray().toTypedArray(), 1)

        Assert.assertArrayEquals(expectedStr, result)

        expectedStr = "".toCharArray().toTypedArray()
        result = ReplaceCharacters
            .replaceInPlace("".toCharArray().toTypedArray(), 0)

        Assert.assertArrayEquals(expectedStr, result)
    }

}
