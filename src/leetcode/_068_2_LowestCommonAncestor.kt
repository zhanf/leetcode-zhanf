package leetcode

import leetcode.tree.TreeNode


/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



         

        示例 1:

        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出: 3
        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
        示例 2:

        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出: 5
        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
         

        说明:

        所有节点的值都是唯一的。
        p、q 为不同节点且均存在于给定的二叉树中。
*/ /**
 * 二叉树的最近公共祖先
 */
fun main(args: Array<String>) {
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    //当 root 为空时中断；父节点不能超过p、q自身节点，超过则中断
    if (null == root || null == p || null == q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    //左右节点为空叶子节点，左右都不包含p、q
    if (null == left && null == right) return root
    //左节点为空，右不为空，p、q可能在右节点
    if (null == left) return right
    //右节点为空，左不为空，p、q可能在左节点
    return if (null == right) left else root
    //左右节点都不为空，说明p、q分列在root的两侧。
}