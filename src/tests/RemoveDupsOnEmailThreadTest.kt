package tests

import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals
import solutions.RemoveDupsOnEmailThread
import utils.SinglyLinkedList

class RemoveDupsOnEmailThreadTest {
    private lateinit var expectedList: SinglyLinkedList<String>
    private lateinit var emailList: SinglyLinkedList<String>

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        expectedList = SinglyLinkedList(0)
        emailList = SinglyLinkedList(0)
    }

    @Test
    fun removeDupsUsingHashMapTest() {
        expectedList.add("AAA")
        expectedList.add("BBB")
        expectedList.add("CCC")
        expectedList.add("DDD")
        expectedList.add("87444")
        expectedList.add("022")
        expectedList.add("kl6")

        emailList.addAll(expectedList)

        emailList.add("AAA")
        emailList.add("87444")

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingHashMap(emailList).toTypedArray()
        )

        expectedList.clear()
        emailList.clear()

        emailList.add("")
        emailList.add("")

        expectedList.add("")

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingHashMap(emailList).toTypedArray()
        )

    }

    @Test
    fun removeDupsUsingPointersTest() {
        expectedList.add("AAA")
        expectedList.add("BBB")
        expectedList.add("CCC")
        expectedList.add("DDD")
        expectedList.add("87444")
        expectedList.add("022")

        emailList.addAll(expectedList)

        emailList.add("AAA")
        emailList.add("87444")
        emailList.add("022")

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingPointers(emailList).toTypedArray()
        )

        expectedList.clear()
        emailList.clear()

        emailList.add("")
        emailList.add("")

        expectedList.add("")

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingPointers(emailList).toTypedArray()
        )

        expectedList.clear()
        emailList.clear()

        expectedList.add("BBB")

        emailList.addAll(expectedList)

        emailList.add("BBB")
        emailList.add("BBB")

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingPointers(emailList).toTypedArray()
        )

        expectedList.clear()
        emailList.clear()

        expectedList.add("AAA")
        expectedList.add("BBB")
        expectedList.add("CCC")
        expectedList.add("DDD")
        expectedList.add("87444")
        expectedList.add("022")

        emailList.addAll(expectedList)
        emailList.addAll(expectedList)

        assertArrayEquals(
                expectedList.toTypedArray(),
                RemoveDupsOnEmailThread.removeDupsUsingPointers(emailList).toTypedArray()
        )

    }

}
