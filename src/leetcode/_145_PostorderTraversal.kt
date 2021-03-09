package leetcode

import leetcode.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
1
\
2
/
3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/
/**
 * 后序遍历
 */
fun postorderTraversal1(root: TreeNode?): List<Int> {
    val res = ArrayList<Int>()
    root ?: return res
    val stack = Stack<TreeNode>()
    var root: TreeNode? = root
    var prev: TreeNode? = null
    while (null != root || stack.isNotEmpty()) {
        while (null != root) {
            stack.push(root)
            root = root.left
        }
        root = stack.pop()
        if (null == root.right || root.right == prev) {
            res.add(root.`val`)
            prev = root
            root = null
        } else {
            stack.push(root)
            root = root.right
        }
    }
    return res
}

private val res = ArrayList<Int>()
fun postorderTraversal2(root: TreeNode?): List<Int> {
    root ?: return res
    postorderTraversal2(root.left)
    postorderTraversal2(root.right)
    res.add(root.`val`)
    return res
}