package leetcode

import leetcode.list.ListNode

class _024_ReverseLinkedList {
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
            var reverseNode = solution.reverseList(node)
            while (null != reverseNode) {
                println("${reverseNode.`val`}")
                reverseNode = reverseNode.next
            }
        }
    }

    class Solution {
        fun reverseList(head: ListNode?): ListNode? {
            var pre: ListNode? = null
            var cur = head
            while (null != cur) {
                val temp = cur.next
                cur.next = pre
                pre = cur
                cur = temp
            }
            return pre
        }

        private fun recur(cur: ListNode?, pre: ListNode?): ListNode? {
            // 返回反转链表的头节点
            if (null == cur) {
                return pre
            }
            val recur = recur(cur.next, cur)
            cur.next = pre
            return recur
        }
    }
}