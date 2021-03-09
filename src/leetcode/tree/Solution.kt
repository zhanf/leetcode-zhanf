package leetcode.tree

import leetcode.list.ListNode

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return helper(root, k, 1) ?: -1
    }

    private fun helper(value: TreeNode?, k: Int, index: Int): Int? {
        value ?: return null
        var curIndex = index
        val target = helper(value.left, k, curIndex)
        target?.let {
            val isTarget = isTarget(k, curIndex)
            if (isTarget) {
                return target
            } else {
                curIndex = index + 1
            }
        }
        return helper(value.right, k, curIndex)
    }

    //目标 index
    private fun isTarget(k: Int, index: Int): Boolean {
        return index >= k
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        l1?:return l2
        l2?:return l2
        val preNode = ListNode(-1)
        var head = preNode
        var nodeL1 = l1
        var nodeL2 = l2
        var a = 0
        var b = 0
        while(null != nodeL1 || null != nodeL2){
            var sum1 = 0
            var sum2 = 0
            if(null != nodeL1){
                sum1 = nodeL1.`val`
            }
            if(null != nodeL2){
                sum2 = nodeL2.`val`
            }
            val sum = sum1+sum2
            b = (sum+a)%10
            a = sum/10
            head.next = ListNode(b)
            head = head.next!!
            nodeL1 = nodeL1?.next
            nodeL2 = nodeL2?.next
        }
        return preNode.next
    }
}