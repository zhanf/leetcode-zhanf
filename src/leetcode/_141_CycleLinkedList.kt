package leetcode

import leetcode.list.ListNode

class _141_CycleLinkedList {
    companion object {
        @JvmStatic
        fun main(array: Array<String>) {

        }
    }

    class Solution {
        fun hasCycle(head: ListNode?): Boolean {
            if (head?.next == null) return false
            var slow = head
            var fast = head.next
            while (fast != null) {
                if (slow != fast) {
                    slow = slow?.next
                    fast = fast.next?.next
                } else {
                    return true
                }
            }
            return false
        }

        fun hasCycle2(head: ListNode?): Boolean {
            if (head?.next == null) return false
            var slow = head
            var fast = head.next
            while (slow != fast) {
                if (null == slow || fast == null) return false
                slow = slow.next
                fast = fast.next?.next
            }
            return true
        }
    }
}