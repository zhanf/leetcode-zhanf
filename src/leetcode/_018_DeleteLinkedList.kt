package leetcode

import leetcode.list.ListNode

class _018_DeleteLinkedList {
    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val node = ListNode(1)
            val node2 = ListNode(2)
            val node3 = ListNode(3)
            val node4 = ListNode(4)
            val node5 = ListNode(5)
            node.next = node2
            node2.next = node3
            node3.next = node4
            node4.next = node5
            val solution = Solution()
            var reverseNode = solution.deleteNode(node, 3)
            while (null != reverseNode) {
                println("${reverseNode.`val`}")
                reverseNode = reverseNode.next
            }
        }
    }

    class Solution {
        fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
            head ?: return null
            val temp = ListNode(0)
            temp.next = head
            var pre = temp
            var cur = head
            while (null != cur) {
                if (cur.`val` == `val`) {
                    pre.next = cur.next
                    break
                }
                pre = cur
                cur = cur.next
            }
            return temp.next
        }
    }
}