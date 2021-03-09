package leetcode

/**
 * 字符串相加
 */
fun addStrings(num1: String, num2: String): String {
    if (num1.isEmpty()) return num2
    if (num2.isEmpty()) return num1
    val max = Math.max(num2.length, num1.length)
    var i = 0
    val sb = StringBuilder()
    var count = 0
    while (i < max) {
        val i1 = num1.length - i - 1
        var s1 = 0
        if (i1 >= 0) {
            s1 = getInt(num1[i1])
        }
        val i2 = num2.length - i - 1
        var s2 = 0
        if (i2 >= 0) {
            s2 = getInt(num2[i2])
        }
        sb.append((s1 + s2 + count) % 10)
        count = (s1 + s2 + count) / 10
        i++
    }
    if (count == 1) {
        sb.append(1)
    }
    return sb.reverse().toString()
}

private fun getInt(ch: Char): Int {
    return ch - '0'
}