package leetcode.list

import leetcode.tree.TreeNode
import java.util.*


class Solution {

    private var target: ListNode? = null

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val pivot = ListNode(-1)
        pivot.next = head
        var fast: ListNode? = head
        var slow: ListNode = pivot
        while (fast?.next != null) {
            if (fast.next?.`val` != slow.next?.`val`) {
                fast = fast.next
                slow = slow.next!!
            } else {
                while (fast?.next != null && fast!!.next?.`val` == slow.next?.`val`) {
                    fast = fast.next
                }
                slow.next = fast?.next
                fast = fast?.next
            }
        }
        return pivot.next
    }

    /**
    复杂度分析：
    时间复杂度 O(n)
    空间复杂度 O(1)
     */
    fun numWays(n: Int): Int {
        var start = 1
        var end = 1
        var sum = 0
        for (i in 0 until n) {
            sum = (start + end) % 1000000007
            start = end
            end = sum
        }
        return start
    }

    /**
    复杂度分析：
    时间复杂度 O log(n)
    空间复杂度 O(1)
     */
    fun findMin(numbers: IntArray?): Int {
        numbers ?: return -1
        if (numbers.size == 1) {
            return numbers[0]
        }
        var low = 0
        var high = numbers.size - 1
        while (low <= high) {
            val poivt = low + (high - low) / 2
            if (numbers[poivt] > numbers[high]) {
                low = poivt + 1
            } else if (numbers[poivt] < numbers[high]) {
                high = poivt
            } else {
                high -= 1
            }
        }
        return numbers[low]
    }

    var loop = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    var num = charArrayOf()
    fun printNumbers(n: Int): String {
        val res = StringBuilder()
        num = CharArray(n)
        dfs(res, 0, n)
        res.deleteCharAt(res.length - 1)
        print("$res")
        return res.toString()
    }

    private fun dfs(res: StringBuilder, x: Int, n: Int) {
        if (x == n) {
            res.append(num.toString()).append(",")
            return
        }
        for (c in loop) {
            num[x] = c
            dfs(res, x + 1, n)
        }
    }

    fun levelOrders(root: TreeNode?): IntArray {
        if (root == null) return IntArray(0)
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        val ans = java.util.ArrayList<Int>()
        while (!queue.isEmpty()) {
            val node = queue.poll()
            ans.add(node.`val`)
            if (node.left != null) queue.add(node.left!!)
            if (node.right != null) queue.add(node!!.right!!)
        }
        val res = IntArray(ans.size)
        for (i in ans.indices) res[i] = ans[i]
        return res
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        val ans = ArrayList<LinkedList<Int>>()
        if (root == null) return ans

        queue.add(root)
        while (!queue.isEmpty()) {
            val nodeList = LinkedList<Int>()
            for (i in 0 until queue.size) {
                val node = queue.poll()
                if (ans.size % 2 == 1) {
                    nodeList.addFirst(node.`val`)
                } else {
                    nodeList.addLast(node.`val`)
                }
                if (node.left != null) queue.add(node.left!!)
                if (node.right != null) queue.add(node!!.right!!)
            }
            if (!nodeList.isEmpty()) {
                ans.add(nodeList)
            }
        }
        return ans
    }

    fun firstUniqChar(s: String): Char {
        var map = HashMap<Char, Boolean>()
        val array = s.toCharArray()
        for (s in array) {
            if (map.containsKey(s)) {
                map.put(s, false)
            } else {
                map.set(s, true)
            }
        }
        for (s in array) {
            if (map[s] == true) {
                return s
            }
        }
        return ' '
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return Math.abs((maxDeath(root.left) - maxDeath(root.right))) <= 1
    }

    fun maxDeath(root: TreeNode?): Int {
        if (null == root) return 0
        return Math.max(maxDeath(root.left), maxDeath(root.right)) + 1
    }

    fun reverseWords(s: String): String {

        val strs = s.trim().split(" ") // 删除首尾空格，分割字符串

        val res = java.lang.StringBuilder()
        for (i in strs.indices.reversed()) { // 倒序遍历单词列表
            if (strs[i] == "") continue  // 遇到空单词则跳过
            res.append(strs[i] + " ") // 将单词拼接至 StringBuilder
        }
        return res.toString().trim { it <= ' ' } // 转化为字符串，删除尾部空格，并返回

    }

    fun findContinuousSequence(target: Int): Array<IntArray> {
        /*var list = ArrayList<IntArray>()
        var i = 1
        var j = 1
        var sum = 0
        while(i<=target/2){
            if(sum>target){
                sum-=i
                i++
            }else if(sum<target){
                sum+=j
                j++
            }else{
                var intArray = IntArray(j-i+1)
                var index = 0
                for(pos in i ..(j+1)){
                    intArray[index] = pos
                    index++
                }
                list.add(intArray)
            }
        }
        return list.toTypedArray()*/
        var i = 1 // 滑动窗口的左边界

        var j = 1 // 滑动窗口的右边界

        var sum = 0 // 滑动窗口中数字的和

        val res: MutableList<IntArray> = ArrayList()

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j
                j++
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i
                i++
            } else {
                // 记录结果
                val arr = IntArray(j - i)
                for (k in i until j) {
                    arr[k - i] = k
                }
                res.add(arr)
                // 左边界向右移动
                sum -= i
                i++
            }
        }

        return res.toTypedArray()
    }

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var i = 0
        val list: MutableList<Int> = ArrayList()
        while ((i + k) < nums.size) {
            var temp = nums[i]
            for (item in i until (i + k + 1)) {
                if (nums[item] > temp) {
                    temp = nums[item]
                }
            }
            list.add(temp)
            i++
        }
        return list.toIntArray()
    }

    fun isStraight(nums: IntArray): Boolean {
        var repeat = HashSet<Int>()
        var max = 0
        var min = 14
        for (num in nums) {
            if (num == 0) continue
            max = Math.max(max, num)
            min = Math.min(num, min)
            if (repeat.contains(num)) return false
        }
        return max - min > 5
    }

    fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
        Arrays.sort(arr)
        var array = IntArray(k)
        for (i in 0 until k) {
            array[i] = arr[i]
        }
        return array
    }

    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]//最大值
        var cur = nums[0]//当前值
        var former = 0//前一个值
        for(item in nums){
            cur = item
            cur += Math.max(0,former)
            max = Math.max(cur,max)
            former = cur
        }
        return max
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val hashSet = HashSet<Char>()
        var max = 0
        var curMax = 0
        val charArray = s.toCharArray()
        for(char in charArray){
            if(!hashSet.contains(char)){
                hashSet.add(char)
                curMax +=1
            }else{
                hashSet.clear()
                max = curMax
                curMax = 0
            }
        }
        return Math.max(max,curMax)
    }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}