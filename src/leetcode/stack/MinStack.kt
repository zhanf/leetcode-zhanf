package leetcode.stack

import java.util.*

class MinStack() {

    /** initialize your data structure here. */

    var stackA = Stack<Int>()
    var stackB = Stack<Int>()
    fun push(x: Int) {
        stackA.push(x)
        if (stackB.isEmpty() || x <= stackB.peek()) {
            stackB.push(x)
        }
    }

    fun pop() {
        if (stackA.isEmpty()) {
            return
        }
        if (stackA.pop() == stackB.peek()) {
            stackB.pop()
        }
    }

    fun top(): Int {
        if (stackA.isEmpty()) {
            return -1
        }
        return stackA.peek()
    }

    fun min(): Int {
        if (stackB.isEmpty()) {
            return -1
        }
        return stackB.peek()
    }

}