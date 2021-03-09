package leetcode.sort


fun main() {

    val array = intArrayOf(-4, 0, 7, 4, 9, -5, -1, 0, -7, -1)
    headSort(array, array.size / 2, array.size)
    for (i in array) {
        print("$i ")
    }

}

fun headSort(array: IntArray, startIndex: Int, size: Int) {
    //构造大顶堆
    for (index in startIndex downTo 0) {
        adjustHeap(array, index, size)
    }
    //替换第0个最后的节点，重新调整堆
    for (index in (size - 1) downTo 1) {
        swap(array, 0, index)
        adjustHeap(array, 0, index)
    }
}

private fun adjustHeap(array: IntArray, start: Int, size: Int) {
    val left = start * 2 + 1
    val right = start * 2 + 2
    var lagest = start
    if (left < size && array[left] > array[lagest]) {
        lagest = left
    }
    if (right < size && array[right] > array[lagest]) {
        lagest = right
    }
    if (start != lagest) {
        swap(array, start, lagest)
        adjustHeap(array, lagest, size)
    }
}

private fun swap(array: IntArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}