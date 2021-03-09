package leetcode.mockInterview

object BinarySearch {
    @JvmStatic
    fun main(array: Array<String>) {

        val nums = intArrayOf(0, 3, 4, 7, 10, 20)
        println("${binarySearch(nums, 21)}")
    }

    fun binarySearch(nums: IntArray, target: Int): Int {

        var i = 0
        var j = nums.size - 1
        while (i <= j) {
            val mid = (i + j) / 2
            when {
                nums[mid] == target -> {
                    return mid
                }
                nums[mid] < target -> {
/*                    if (mid + 1 < nums.size && nums[mid + 1] > target) {
                        return -mid - 1
                    }*/
                    i = mid + 1
                }
                else -> {
/*                    if (nums[mid - 1] < target) {
                        return -mid - 1
                    }*/
                    j = mid - 1
                }
            }
        }
        return -1
    }
}