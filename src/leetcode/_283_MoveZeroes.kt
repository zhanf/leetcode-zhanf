package leetcode

/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
object _283_MoveZeroes {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    fun moveZeroes(nums: IntArray): Unit {
        var i = 0
        for ((index, num) in nums.withIndex()) {
            if (num != 0) {
                val temp = nums[index]
                nums[index] = nums[i]
                nums[i++] = temp
            }
        }
    }
}