package leetcode.string

import java.util.*
import kotlin.collections.HashMap

class Solution {
    fun isValid(s: String): Boolean {
        if (s?.length ?: 0 == 0) {
            return true
        }
        val map = HashMap<Char, Char>()
        map.put('(', ')')
        map.put('{', '}')
        map.put('[', ']')
        val stack = LinkedList<Char>()
        stack.push('?')
        var chars = s.toCharArray()

        for (char in chars) {
            if (map.containsKey(char)) {
                stack.push(char)
            } else if (char != map.get(stack.pop())) {
                return false
            }
        }
        return stack.size == 1
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        for ((index, num) in nums.withIndex().reversed()) {
            if (num < target) {
                return index + 1
            }
        }
        return 0
    }

    fun plusOne(digits: IntArray): IntArray {
        for (index in (digits.size-1) downTo 0){
            digits[index]+=1
            digits[index] = digits[index]%10
            if(digits[index]!=0){
                return digits
            }
        }
        val array = IntArray(digits.size+1)
        array[0] =1
        return array
    }

    fun test(test:String?){
        test?.let {
            print(test.length)
        }
    }
}