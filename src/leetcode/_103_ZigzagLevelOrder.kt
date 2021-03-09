package leetcode

import leetcode.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/*
103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

3
/ \
9  20
/  \
15   7
返回锯齿形层序遍历如下：

[
[3],
[20,9],
[15,7]
]
*/

fun main(array: Array<String>) {
    //[3,9,20,null,null,15,7]
    val node1 = TreeNode(3)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)
    node3.left = node4
    node3.right = node5
    node1.left = node2
    node1.right = node3
    val zigzagLevelOrder = zigzagLevelOrder2(node1)
    zigzagLevelOrder.forEach {
        print("${it}    ")
        println()
    }
}

/**
 * 二叉树的锯齿形层序遍历
 */
fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val res = LinkedList<List<Int>>()
    root ?: return res
    var intList = LinkedList<Int>()
    var nodeList = LinkedList<TreeNode?>()
    var isOrderLeft = false
    nodeList.add(root)
    nodeList.add(null)
    while (nodeList.isNotEmpty()) {
        val node = nodeList.pollFirst()
        if (null != node) {
            if (isOrderLeft) {
                intList.addFirst(node.`val`)
            } else {
                intList.addLast(node.`val`)
            }
            if (null != node.left) {
                nodeList.addLast(node.left)
            }
            if (null != node.right) {
                nodeList.addLast(node.right)
            }
        } else {
            res.add(intList)
            if (nodeList.isNotEmpty()) {
                nodeList.add(null)
            }
            intList = LinkedList<Int>()
            isOrderLeft = !isOrderLeft
        }
    }
    return res
}

/**
 * 层序遍历输出每排最右节点
 */
fun zigzagLevelOrder2(root: TreeNode?): List<Int> {
    val res = ArrayList<Int>()
    root ?: return res
    var nodeList = LinkedList<TreeNode?>()
    nodeList.add(root)
    nodeList.add(null)
    var value = -1
    while (nodeList.isNotEmpty()) {
        val node = nodeList.pollFirst()
        if (null != node) {
            value = node.`val`
            if (null != node.left) {
                nodeList.addLast(node.left)
            }
            if (null != node.right) {
                nodeList.addLast(node.right)
            }
        } else {
            res.add(value)
            if (nodeList.isNotEmpty()) {
                nodeList.add(null)
            }
        }
    }
    return res
}