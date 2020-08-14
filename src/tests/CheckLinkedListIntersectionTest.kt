package tests

import io.mockk.MockKAnnotations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import solutions.CheckLinkedListIntersection
import utils.Node
import utils.SinglyLinkedList

class CheckLinkedListIntersectionTest {

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun getIntersectingNodeFromTest() {
        val listA = SinglyLinkedList<Int>(0)
        val listB = SinglyLinkedList<Int>(0)

        var intersectingNode = Node(88)
        var secondNode = Node(121)

        listA.add(12)
        listA.add(13)
        listA.add(1)
        listA.add(-5)
        listA.addNode(intersectingNode)
        listA.addNode(secondNode)

        listB.add(7)
        listB.addNode(intersectingNode)
        listB.addNode(secondNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getIntersectingNodeFrom(listA, listB))

        intersectingNode = Node(21)
        secondNode = Node(5)
        val thirdNode = Node(-7541)

        listA.clear()
        listB.clear()

        listA.addNode(intersectingNode)
        listB.addNode(intersectingNode)

        listA.addNode(secondNode)
        listB.addNode(secondNode)

        listA.addNode(thirdNode)
        listB.addNode(thirdNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getIntersectingNodeFrom(listA, listB))

        listA.clear()
        listB.clear()

        intersectingNode = Node(21)
        secondNode = Node(-7)

        listA.add(-87)
        listA.addNode(intersectingNode)
        listA.addNode(secondNode)
        listA.add(-787)
        listA.add(-157)

        listB.add(10)
        listB.add(100)
        listB.addNode(intersectingNode)
        listB.addNode(secondNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getIntersectingNodeFrom(listA, listB))

        listA.clear()
        listB.clear()

        listA.add(12)
        listA.add(13)
        listA.add(1)
        listA.add(-5)
        listA.addNode(intersectingNode)
        listA.addNode(secondNode)

        listB.add(7)
        listB.addNode(intersectingNode)
        listB.addNode(secondNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getIntersectingNodeFrom(listB, listA))

        // no intersecting node
        listB.clear()
        listB.add(1)
        listB.add(21)
        listB.add(-7)

        assertEquals(null, CheckLinkedListIntersection.getIntersectingNodeFrom(listA, listB))

        listA.clear()
        listB.clear()

        assertEquals(null, CheckLinkedListIntersection.getIntersectingNodeFrom(listA, listB))
    }

    @Test
    fun getPerfectIntersectingNodeFromTest() {
        val listA = SinglyLinkedList<Int>(0)
        val listB = SinglyLinkedList<Int>(0)

        var intersectingNode = Node(88)
        var secondNode = Node(121)

        listA.add(12)
        listA.add(13)
        listA.add(1)
        listA.add(-5)
        listA.addNode(intersectingNode)
        listA.addNode(secondNode)

        listB.add(7)
        listB.addNode(intersectingNode)
        listB.addNode(secondNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getPerfectIntersectingNodeFrom(listA, listB))

        intersectingNode = Node(21)
        secondNode = Node(5)
        val thirdNode = Node(-7541)

        listA.clear()
        listB.clear()

        listA.addNode(intersectingNode)
        listB.addNode(intersectingNode)

        listA.addNode(secondNode)
        listB.addNode(secondNode)

        listA.addNode(thirdNode)
        listB.addNode(thirdNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getPerfectIntersectingNodeFrom(listA, listB))

        intersectingNode = Node(21)
        secondNode = Node(-7)

        listA.clear()
        listB.clear()

        listA.add(12)
        listA.add(13)
        listA.add(1)
        listA.add(-5)
        listA.addNode(intersectingNode)
        listA.addNode(secondNode)

        listB.add(7)
        listB.addNode(intersectingNode)
        listB.addNode(secondNode)

        assertEquals(intersectingNode, CheckLinkedListIntersection.getPerfectIntersectingNodeFrom(listB, listA))

        // no intersecting node
        listB.clear()
        listB.add(1)
        listB.add(21)
        listB.add(-7)

        assertEquals(null, CheckLinkedListIntersection.getPerfectIntersectingNodeFrom(listA, listB))

        listA.clear()
        listB.clear()

        assertEquals(null, CheckLinkedListIntersection.getPerfectIntersectingNodeFrom(listA, listB))
    }

}
