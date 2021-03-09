package leetcode.repeat

import leetcode.list.ListNode
import java.util.*

class Solution {
    /**
    复杂性分析
    时间复杂度：O(n)O(n)。
    遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)O(1)，故总的时间复杂度是 O(n)O(n)。
    空间复杂度：O(n)O(n)。不重复的每个元素都可能存入集合，因此占用 O(n)O(n) 额外空间。
     */
    fun findRepeatNumber(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (!set.add(num)) {
                return num
            }
        }
        return -1;
    }

    /**
    复杂度分析：
    时间复杂度 O(M+N)O(M+N) ：其中，NN 和 MM 分别为矩阵行数和列数，此算法最多循环 M+NM+N 次。
    空间复杂度 O(1)O(1) : i, j 指针使用常数大小额外空间。
     */
    fun findNumberIn2DArray(matrix: Array<IntArray>?, target: Int): Boolean {
        if (null == matrix || matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        var row = matrix.size - 1
        var column = 0

        while (row >= 0 && column < matrix[0].size) {
            val num = matrix[row][column]
            if (num == target) {
                return true
            } else if (num > target) {
                row--
            } else {
                column++
            }
        }
        return false
    }

    /**
    复杂度分析：
    时间复杂度 O(n)
    空间复杂度 O(n)
     */
    fun replaceSpace(s: String): String {
        val split = s.toCharArray()
        val sb = StringBuilder()
        for (char in split) {
            if (char.toString() == " ") {
                sb.append("%20")
            } else {
                sb.append(char)
            }
        }
        return sb.toString()
    }

    /**
    复杂度分析：
    时间复杂度 O(n)+O(n) = O(n)
    空间复杂度 O(n)+O(n) = O(n)
     */
    fun reversePrint(head: ListNode?): IntArray {
        val stack = Stack<Int>()
        var node = head
        while (null != node) {
            stack.push(node.`val`)
            node = node.next
        }
        val result = IntArray(stack.size)
        val size = result.size
        for (i in 0 until size){
            result[i] = stack.pop()
        }
        return result
    }
}