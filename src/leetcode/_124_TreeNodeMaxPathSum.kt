package leetcode

/*
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

 

示例 1：

输入：[1,2,3]

1
/ \
2   3

输出：6
示例 2：

输入：[-10,9,20,null,null,15,7]

      -10
   / \
    9     20
    /  \
   15   7

输出：42
*/

import leetcode.tree.TreeNode
import kotlin.math.max

fun main(array: Array<String>) {
    val root = TreeNode(1)
    val rootLeft = TreeNode(2)
    val rootRight = TreeNode(3)
    val rootLeftLeft = TreeNode(4)
    val rootLeftRight = TreeNode(5)
    val rootRightLeft = TreeNode(4)
    val rootRightRight = TreeNode(5)

    rootRight.left = rootRightLeft
    rootRight.right = rootRightRight
    root.right = rootRight

    rootLeft.left = rootLeftLeft
    rootLeft.right = rootLeftRight
    root.left = rootLeft


    println("${maxPath(root)}")
}

var maxSum = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    maxGain(root)
    return maxSum
}

/**
 * 最大路径和
 */
fun maxGain(node: TreeNode?): Int {
    node ?: return 0
    val leftGain = Math.max(0, maxGain(node.left))
    val rightGain = Math.max(0, maxGain(node.right))

    maxSum = Math.max(maxSum, node.`val` + leftGain + rightGain)

    return node.`val` + Math.max(leftGain, rightGain)
}

/**
 * 最大路径
 */
fun maxPath(root: TreeNode?): Int {
    dsf(root)
    return maxSum
}

fun dsf(node: TreeNode?): Int {
    node ?: return 0
    //左最大路径
    val leftPath = dsf(node.left)
    //右最大路径
    val rightPath = dsf(node.right)
    //总最大路径为 左+右+1(当前)
    maxSum = max(maxSum, leftPath + rightPath + 1)
    //该节点最大路径 最大的左/右+1(当前)
    return max(leftPath, rightPath) + 1
}