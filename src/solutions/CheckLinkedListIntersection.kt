package solutions

import utils.Node
import utils.SinglyLinkedList

class CheckLinkedListIntersection {

    /**
     * I decided to use "companion object" to facilitate code testing.
     * */
    companion object {

        /**
         * This function was built assuming that one list could have more elements after the intersection.
         *
         * Example:
         * A: 55 -> -3 -> 31 -> -87 -> "21" -> "7" -> -787 -> 42
         * B: 10 -> 100 -> "21" -> "7"
         *
         * Where the numbers between double quotes are those that are in the intersection.
         * */
        private fun iterateThrough(first: SinglyLinkedList<Int>, second: SinglyLinkedList<Int>): Node<Int>? {
            var diff = first.size - second.size
            var node = first.head

            while (node != null && diff > 0) {
                node = node.next

                diff--
            }

            while (node != null) {
                var nodeB = second.head

                while(nodeB != null) {
                    if (node == nodeB) {
                        return node
                    }

                    nodeB = nodeB.next
                }

                node = node.next
            }

            return null
        }

        fun getIntersectingNodeFrom(listA: SinglyLinkedList<Int>, andListB: SinglyLinkedList<Int>): Node<Int>? {
            if((listA.isEmpty() || andListB.isEmpty()) && listA.tail != andListB.tail) {
                return null
            }

            if(listA.size >= andListB.size) {
                return iterateThrough(listA, andListB)
            }

            return iterateThrough(andListB, listA)
        }

        /**
         * Lists with perfect intersection.
         *
         * Example:
         * A: -87 -> 21 -> "10" -> "56" -> "7"
         * B: 10 -> 100 -> 21 -> 85 -> 41 -> "10" -> "56" -> "7"
         *
         * Where the numbers between double quotes are those that are in the intersection.
         * */
        private fun iteratePerfectIntersection(first: SinglyLinkedList<Int>, second: SinglyLinkedList<Int>): Node<Int>? {
            var diff = first.size - second.size
            var node = first.head

            while (node != null && diff > 0) {
                node = node.next

                diff--
            }

            var nodeB = second.head

            while (node != null) {
                if (node == nodeB) {
                    return node
                }

                nodeB = nodeB!!.next
                node = node.next
            }

            return null
        }

        fun getPerfectIntersectingNodeFrom(listA: SinglyLinkedList<Int>, andListB: SinglyLinkedList<Int>): Node<Int>? {
            if((listA.isEmpty() || andListB.isEmpty()) && listA.tail != andListB.tail) {
                return null
            }

            if(listA.size >= andListB.size) {
                return iteratePerfectIntersection(listA, andListB)
            }

            return iteratePerfectIntersection(andListB, listA)
        }

    }

}
