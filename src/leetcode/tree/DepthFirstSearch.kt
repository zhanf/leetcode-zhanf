package leetcode.tree

/**
 * 深度优先遍历
 */
class DepthFirstSearch {

    private val result = mutableListOf<Int>()

    fun dsf(root: TreeNode, k: Int): Int {
        helper(root, result, k)
        return if (result.size > 0) result[0] else 0
    }

    private fun helper(value: TreeNode?, result: MutableList<Int>, k: Int) {
        value ?: return
        helper(value.left, result, k)
        val checkShouldAdd = checkShouldAdd(value.`val`, k)
        if (!checkShouldAdd) {
            return
        }
        helper(value.right, result, k)
    }

    private fun checkShouldAdd(value: Int, k: Int): Boolean {
        val shouldAdd = result.size < k
        if (shouldAdd) {
            result.add(0, value)
        }
        return shouldAdd
    }

}

class TreeNode(value: Int) {
    var `val`: Int = value
    var left: TreeNode? = null
    var right: TreeNode? = null

}