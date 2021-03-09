package leetcode.tree

class BuildNode {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var map = HashMap<Int, Int>()
        for ((index, item) in inorder.withIndex()) {
            map.put(item, index)
        }
        val length = preorder.size
        return buildTree(preorder, 0, length - 1, inorder, 0, length - 1, map)
    }

    private fun buildTree(
        preorder: IntArray,
        preOrderStart: Int,
        preOrderEnd: Int,
        inorder: IntArray,
        inorderStart: Int,
        inorderEnd: Int,
        map: HashMap<Int, Int>
    ): TreeNode? {
        if (preOrderStart > preOrderEnd) {
            return null
        }
        val rootValue: Int = preorder[preOrderStart]
        val root = TreeNode(rootValue)
        if (preOrderStart == preOrderEnd) {
            return root
        } else {
            val rootIndex: Int = map.get(preorder[preOrderStart])!!
            val leftNodes = rootIndex - inorderStart
            val rightNodes = inorderEnd - rootIndex
            root.left = buildTree(
                preorder,
                preOrderStart + 1,
                preOrderStart + leftNodes,
                inorder,
                inorderStart,
                rootIndex - 1,
                map
            )
            root.right =
                buildTree(
                    preorder,
                    preOrderEnd - rightNodes + 1,
                    preOrderEnd,
                    inorder,
                    rootIndex + 1,
                    inorderEnd,
                    map
                )
            return root
        }
    }

}