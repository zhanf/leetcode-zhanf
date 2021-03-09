package leetcode

import leetcode.tree.TreeNode
import java.util.*
/*

144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[1,2]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶：递归算法很简单，你可以通过迭代算法完成吗？
*/

/**
 * dfs实现
 */
fun preorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    root ?: return res
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        res.add(node.`val`)
        if (null != node.right) {
            stack.push(node.right)
        }
        if (null != node.left) {
            stack.push(node.left)
        }
    }
    return res
}

/**
 * 递归实现
 */
private val res = mutableListOf<Int>()
fun preorderTraversal2(root: TreeNode?): List<Int> {
    root?:return res
    res.add(root.`val`)
    preorderTraversal(root.left)
    preorderTraversal(root.right)
    return res
}