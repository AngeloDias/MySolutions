package solutions

import utils.SinglyLinkedList

class RemoveDupsOnEmailThread {

    /**
     * I decided to use "companion object" to facilitate code testing.
     * */
    companion object {

        fun removeDupsUsingHashMap(unsortedList: SinglyLinkedList<String>): SinglyLinkedList<String> {
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
            var current = linkedList.head

            while(current != null) {
                var runner = current

                while (runner!!.next != null) {
                    if(current.value == runner.next!!.value) {

                        runner.next = runner.next!!.next
                    } else {
                        runner = runner.next
                    }

                }

                current = current.next
            }

            return linkedList
        }
    }

}
