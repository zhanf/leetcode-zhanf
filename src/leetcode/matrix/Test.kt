package leetcode.matrix

internal class Test {
    fun movingCount(m: Int, n: Int, k: Int): Int {
        val visited = Array(m) { BooleanArray(n) }
        return dfs(0, 0, 0, 0, m, n, k, visited)
    }


    private fun dfs(i: Int, j: Int, si: Int, sj: Int, m: Int, n: Int, k: Int, visited: Array<BooleanArray>): Int {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0
        visited[i][j] = true
        return 1 +
                dfs(
                    i + 1,
                    j,
                    if ((i + 1) % 10 != 0) si + 1 else si - 8,
                    sj,
                    m,
                    n,
                    k,
                    visited
                ) +
                dfs(
                    i,
                    j + 1,
                    si,
                    if ((j + 1) % 10 != 0) sj + 1 else sj - 8,
                    m,
                    n,
                    k,
                    visited
                )
    }
}