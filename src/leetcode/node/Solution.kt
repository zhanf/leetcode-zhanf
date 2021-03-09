package leetcode.node

import jdk.nashorn.internal.objects.NativeArray.push
import leetcode.list.ListNode
import leetcode.tree.TreeNode
import java.util.*

class Solution {

    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        head ?: return null
        val dummy = ListNode(0)
        dummy.next = head
        var cur = head
        var pre = dummy
        while (null != cur) {
            if (cur.`val` == `val`) {
                pre.next = cur.next
                break
            }
            pre = cur
            cur = cur.next
        }
        return dummy.next
    }

    fun exchange(nums: IntArray): IntArray? {
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            while (i < j && nums[i] and 1 == 1) {
                i++
            }
            while (j > i && nums[j] and 1 == 0) {
                j--
            }
            var temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }
        return nums
    }

    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        var fronter = head
        var later = head
        for(i in 0 until k){
            fronter = fronter?.next
        }
        while(fronter != null){
            fronter = fronter.next
            later = later?.next
        }
        return later
    }

    fun reverseList(head: ListNode?): ListNode? {
        var head = head
        if(null == head || null == head.next){
            return head
        }
        var next = head.next
        var reverse = reverseList(next)
        next?.next = head
        head.next = null
        return reverse
    }

    fun mirrorTree(root: TreeNode?): TreeNode? {
        root?:return null
        var stack = Stack<TreeNode>()
        stack.add(root)
        while(!stack.isEmpty()){
            val node = stack.pop()
            if(null != root.left)stack.add(root.left)
            if(null != root.right)stack.add(root.right)
            val temp = root.left
            node.left = root.right
            node.right = temp
        }
        return root
    }


}