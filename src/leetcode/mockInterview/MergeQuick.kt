package leetcode.mockInterview

object MergeQuick {

    @JvmStatic
    fun main(array: Array<String>) {
        val nums = intArrayOf(0, 10, 1, 2, 30, 29, 12, 45, 2, 4, 5, 9)
        val sortArray = sortArray(nums)
        sortArray.forEach {
            println("$it")
        }
    }

    private fun sortArray(nums: IntArray): IntArray {
        val mid = nums.size / 2
        var left = nums.slice(0..mid).toIntArray()
        if (left.size <= 2) {
            sort(left)
        } else {
            left = sortArray(left)
        }
        var right = nums.slice(mid + 1 until nums.size).toIntArray()
        if (right.size <= 2) {
            sort(right)
        } else {
            right = sortArray(right)
        }
        return merge(left, right)
    }

    fun sort(nums: IntArray): IntArray {
        if (nums.size < 2) {
            return nums
        }
        if (nums[0] > nums[1]) {
            val temp = nums[0]
            nums[0] = nums[1]
            nums[1] = temp
        }
        return nums
    }

    fun merge(left: IntArray, right: IntArray): IntArray {
        val newArray = IntArray(left.size + right.size)
        var i = 0
        var j = 0
        var index = 0
        while (i < left.size || j < right.size) {
            if (i < left.size && j < right.size) {
                if (left[i] <= right[j]) {
                    newArray[index++] = left[i]
                    i++
                } else {
                    newArray[index++] = right[j]
                    j++
                }
            } else if (i < left.size) {
                newArray[index++] = left[i]
                i++
            } else if (j < right.size) {
                newArray[index++] = right[j]
                j++
            }
        }
        return newArray
    }

}