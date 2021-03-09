package leetcode

import leetcode.tree.TreeNode
import java.util.*

/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

fun main(array: Array<String>) {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    node1.right = node2
    node2.left = node3
    inorderTraversal1(node1)
}

/**
 * dfs实现
 */
fun inorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    root ?: return res
    val stack = Stack<TreeNode>()
    var root: TreeNode? = root
    while (null != root || stack.isNotEmpty()) {
        while (null != root) {
            stack.push(root)
            root = root.left
        }
        root = stack.pop()
        res.add(root.`val`)
        root = root.right
    }
    return res
}

/**
 * 递归实现
 */
private val res = mutableListOf<Int>()
fun inorderTraversal2(root: TreeNode?): List<Int> {
    root ?: return res
    inorderTraversal2(root.left)
    res.add(root.`val`)
    inorderTraversal2(root.right)
    return res
}