package leetcode.matrix

class Matrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (null == matrix || matrix.size == 0) {
            return ArrayList()
        }
        var l = 0
        var r = matrix[0].size - 1
        var t = 0
        var b = matrix.size - 1
        var res = ArrayList<Int>((r + 1) * (b + 1))
        while (true) {
            for (i in l until (r + 1)) res.add(matrix[t][i])
            if (++t > b) break
            for (i in t until (b + 1)) res.add(matrix[i][r])
            if (--r < l) break
            for (i in r downTo l) res.add(matrix[b][i])
            if (--b < t) break
            for (i in b downTo t) res.add(matrix[i][l])
            if (++l > r) break
        }
        return res
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty() || board[0].isEmpty()) {
            return false
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (dfs(board, i, j, word, 0)) return true
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, word: String, k: Int): Boolean {
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[k]) {
            return false
        }
        if (k == word.length - 1) return true
        val temp = board[i][j]
        board[i][j] = '/'
        val result = (dfs(board, i + 1, j, word, k + 1) ||
                dfs(board, i - 1, j, word, k + 1) ||
                dfs(board, i, j + 1, word, k + 1) ||
                dfs(board, i, j - 1, word, k + 1))
        board[i][j] = temp
        return result
    }
}