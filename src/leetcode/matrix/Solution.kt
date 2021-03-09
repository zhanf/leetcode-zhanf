package leetcode.matrix

class Solution {
    fun movingCount(m: Int, n: Int, k: Int): Int {
        val visited = Array(m) { BooleanArray(n) }
        return dfs(0, 0, 0, 0, m, n, k, visited)
    }

    fun dfs(i: Int, j: Int, si: Int, sj: Int, m: Int, n: Int, k: Int, visited: Array<BooleanArray>): Int {
        if (si + sj > k || i >= m || j >= n || visited[i][j]) return 0
        visited[i][j] = true
        return 1 +
                dfs(
                    i + 1,
                    j,
                    if ((i + 1) % 10 == 0) si - 8 else si + 1,
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
                    if ((j + 1) % 10 == 0) sj - 8 else sj + 1,
                    m,
                    n,
                    k,
                    visited
                )
    }
/*

    fun cuttingRope(n: Int): Int {
        if(n<=3)return n-1
        val a = (n/3)
        val b = (n%3).toInt()
        if(b == 0) return Math.pow(3.toDouble(),a.toDouble()).toInt()
        if(b == 1) return Math.pow(3.toDouble(),(a-1).toDouble()).toInt()*4
        return Math.pow(3.toDouble(),a.toDouble()).toInt()*2
    }
*/


    fun cuttingRope(n: Int): Int {
        if (n <= 3) return n - 1
        val value = help(n)
        if (value < 1000000007) {
            return value
        }
        var start = 1
        var end = n
        while (start <= end) {
            val mid = (start + end) / 2
            val midValue = help(mid)
            if (midValue >= 1000000007) {
                end = mid - 1
            } else if (midValue < 1000000007) {
                start = mid
            }
            print("start:${start}")
        }
        return help(start)
    }

    fun help(n: Int): Int {
        var a = (n / 3).toDouble()
        var b = (n % 3).toDouble()
        if (b.toInt() == 0) return Math.pow(3.toDouble(), a).toInt()
        if (b.toInt() == 1) return Math.pow(3.toDouble(), (a - 1)).toInt() * 4
        return Math.pow(3.toDouble(), a).toInt() * 2
    }
}