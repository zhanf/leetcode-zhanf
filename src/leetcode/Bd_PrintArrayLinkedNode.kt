package leetcode

fun main() {
    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(4, 5, 6)
    val array3 = intArrayOf(7, 8, 9)
    val array = arrayOf(array1, array2, array3)

    findNext(array, 0, 0, arrayListOf())
    for (re in res) {
        re.forEach {
            print("$it    ")
        }
        println()
    }
}

/**
 * 二维数组 mXn
 * [[1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9],
 * ]
 * 打印 0,0 到 m-1,n-1 索引的所有路径，每一步只能向右或向下移动
 */

private val res = arrayListOf<List<Int>>()
private val right = intArrayOf(0, 1)
private val bottom = intArrayOf(1, 0)

fun findNext(array: Array<IntArray>, i: Int, j: Int, list: ArrayList<Int>) {
    val m = array.size
    val n = array[0].size
    if (i < m && j < n) {
        list.add(array[i][j])
        if (i == m - 1 && j == n - 1) {
            res.add(list)
        } else {
            var newList = arrayListOf<Int>()
            newList.addAll(list)
            findNext(array, i + right[0], j + right[1], newList)
            newList = arrayListOf()
            newList.addAll(list)
            findNext(array, i + bottom[0], j + bottom[1], newList)
        }
    }
}
