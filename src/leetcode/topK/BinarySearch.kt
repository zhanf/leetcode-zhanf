package leetcode.topK

object BinarySearch {

    @JvmStatic
    fun main(array: Array<String>) {
        val array = intArrayOf(0, 2, 3, 4, 5, 6, 7, 8, 9)
//        val position = binarySearch(array, 4)
        val position = binarySearch2(array, 10, 0, array.size - 1)
        println("$position")
    }

    private fun binarySearch(intArray: IntArray, target: Int): Int {
        var i = 0
        var j = intArray.size - 1
        while (i <= j) {
            val mid = (i + j) / 2
            when {
                intArray[mid] == target -> {
                    return mid
                }
                intArray[mid] > target -> {
                    j = mid - 1
                }
                else -> {
                    i = mid + 1
                }
            }
        }
        return -1
    }

    private fun binarySearch(
        intArray: IntArray,
        target: Int,
        fromIndex: Int = 0,
        toIndex: Int = intArray.size - 1
    ): Int {
        if (fromIndex > toIndex) return -(fromIndex + 1)
        val mid = (fromIndex + toIndex) shr 1
        return when {
            intArray[mid] == target -> return mid
            intArray[mid] > target -> binarySearch(intArray, target, fromIndex, mid - 1)
            else -> binarySearch(intArray, target, mid + 1, toIndex)
        }
    }

    private fun binarySearch2(
        intArray: IntArray,
        target: Int,
        fromIndex: Int = 0,
        toIndex: Int = intArray.size - 1
    ): Int {
        var fromIndex = fromIndex
        var toIndex = toIndex
        while (fromIndex <= toIndex) {
            val mid = (fromIndex + toIndex) shr 1
            when {
                intArray[mid] == target -> return mid
                intArray[mid] > target -> toIndex = mid - 1
                else -> fromIndex = mid + 1
            }
        }
        return -(fromIndex + 1)
    }

}