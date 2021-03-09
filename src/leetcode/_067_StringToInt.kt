package leetcode

class _067_StringToInt {
    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val solution = Solution()
            val strToInt = solution.strToInt(" -214 ")
            println("$strToInt")

        }
    }

    class Solution {
        fun strToInt(str: String): Int {
            var sign = 1
            var res = 0
            var index = 0
            if (str.length == 0) return 0
            val intMax = Int.MAX_VALUE / 10
            while (str[index] == ' ') {
                if (++index == str.length) return 0
            }
            if (str[index] == '-') {
                sign = -1
            }
            if (str[index] == '-' || str[index] == '+') {
                index++
            }
            while (index < str.length) {
                val char = str[index++]
                if (char > '9' || char < '0') {
                    break
                }
                if (res > intMax || (res == intMax && char > '7')) {
                    return if (sign == 1) {
                        Int.MAX_VALUE
                    } else {
                        Int.MIN_VALUE
                    }
                }
                res = res * 10 + (char - '0')
            }
            if (sign == -1) {
                res = 0 - res
            }
            return res
        }
    }
}