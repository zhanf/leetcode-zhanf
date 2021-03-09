package leetcode

import leetcode.list.ListNode
import java.util.*

class _382_RandomLinkedList {


    companion object {

        @JvmStatic
        fun main(array: Array<String>) {
            val head = ListNode(1)
            head.next = ListNode(2)
            head.next!!.next = ListNode(3)
            val solution = Solution(head)
            val random = solution.getRandom()
            println("$random")
        }
    }

    class Solution(head: ListNode?) {

        private val random: Random = Random()
        var head: ListNode? = null

        fun getRandom(): Int {
            head ?: return -1
            var cur = head
            var value = cur!!.`val`
            var i = 0
            while (cur != null) {
                i++
                if (random.nextInt(i) == 0) {
                    value = cur.`val`
                }
                cur = cur.next
            }
            return value
        }

        init {
            this.head = head
        }
    }
}