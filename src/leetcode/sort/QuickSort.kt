package leetcode.sort

object QuickSort {
    @JvmStatic
    fun main(array: Array<String>) {
        val nums = intArrayOf(0, 1, -1, 2, -10, 20, -5, 21, -1)
        quickSort(nums)
        nums.forEach {
            println("$it")
        }
    }

    fun quickSort(nums: IntArray?) {
        nums ?: return
        sort2(nums, 0, nums.size - 1)
    }

    private fun sort1(arrays: IntArray, start: Int, end: Int): IntArray {
        var arrays = arrays
        var left = start
        var right = end
        while (left < right) {
            while (left < right && arrays[right] > arrays[start]) right--
            while (left < right && arrays[left] < arrays[start]) left++
            if (left < right && arrays[left] == arrays[right]) {
                left++
            } else {
                swap(arrays, left, right)
            }
        }
        if (start < left - 1) {
            arrays = sort1(arrays, start, left - 1)
        }
        if (end > right + 1) {
            arrays = sort1(arrays, right + 1, end)
        }
        return arrays
    }

    private fun sort2(arrays: IntArray, start: Int, end: Int) {
        if (start < end) {
            val partition = partition(arrays, start, end)
            sort2(arrays, start, partition - 1)
            sort2(arrays, partition + 1, end)
        }
    }

    private fun partition(arrays: IntArray, start: Int, end: Int): Int {
        var index = start + 1
        for (i in start + 1..end) {
            if (arrays[i] < arrays[start]) {
                swap(arrays, i, index)
                index++
            }
        }
        swap(arrays, start, index - 1)
        return index - 1
    }

    private fun swap(arrays: IntArray, left: Int, right: Int) {
        val temp = arrays[left]
        arrays[left] = arrays[right]
        arrays[right] = temp
    }
}