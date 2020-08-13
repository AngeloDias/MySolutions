package solutions

import utils.SinglyLinkedList
import java.util.*
import kotlin.collections.HashMap

class RemoveDupsOnEmailThread {

    companion object {

        fun removeDupsUsingHashTable(unsortedList: SinglyLinkedList<String>): SinglyLinkedList<String> {
            val mapMemory = HashMap<String, String>()
            val dupsRemoved = SinglyLinkedList<String>(0)

            unsortedList.forEach {
                if(!mapMemory.containsKey(it)) {
                    dupsRemoved.add(it)
                    mapMemory[it] = it
                }
            }

            return dupsRemoved
        }

        fun removeDupsUsingPointers(linkedList: SinglyLinkedList<String>): SinglyLinkedList<String> {
            val iterator = linkedList.iterator()
            var current = linkedList.head

            while(iterator.hasNext()) {
                var runner = current

                while (runner!!.next != null) {
                    if(current!!.value == runner.next!!.value) {

                        runner.next = runner.next!!.next
                    } else {
                        runner = runner.next
                    }

                }

                current = current!!.next

                iterator.next()
            }

            return linkedList
        }
    }

}
