package leetcode

import java.util.*

/*使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
注意:

你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

*/

class _225_QueueInplStack {

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val stack = MyStack()
            stack.push(1)
            stack.push(2)
            println("${stack.top()}")
            println("${stack.pop()}")
            println("${stack.empty()}")
        }
    }
}

/**
 * 也可用单队列实现
 */
class MyStack {

    /** Initialize your data structure here. */

    private var queue1: Queue<Int> = LinkedList<Int>()
    private var queue2: Queue<Int> = LinkedList<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue1.offer(x)
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll())
        }
        val temp = queue1
        queue1 = queue2
        queue2 = temp
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        if (empty()) {
            return -1
        }
        return queue2.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        if (empty()) return -1
        return queue2.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue2.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */

