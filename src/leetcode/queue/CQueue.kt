package leetcode.queue

import java.util.*
import java.util.concurrent.locks.ReentrantLock

/**
复杂度分析：
由于问题特殊，以下分析仅满足添加 NN 个元素并删除 NN 个元素，即栈初始和结束状态下都为空的情况。

时间复杂度： appendTail()函数为 O(1)O(1) ；deleteHead() 函数在 NN 次队首元素删除操作中总共需完成 NN 个元素的倒序。
空间复杂度 O(N)O(N) ： 最差情况下，栈 A 和 B 共保存 NN 个元素
 */
class CQueue() {

    private val stackPush = Stack<Int>()
    private val stackDelete = Stack<Int>()
    fun appendTail(value: Int) {
        stackPush.add(value)
    }

    fun deleteHead(): Int {
        val reentrantLock = ReentrantLock()
        reentrantLock.lock()
        reentrantLock.unlock()
        val newCondition = reentrantLock.newCondition()
        newCondition.await()
        newCondition.signal()
        if (!stackDelete.isEmpty()) {
            return stackDelete.pop()
        }
        if (stackPush.isEmpty()) {
            return -1
        }
        while (stackPush.isNotEmpty()) {
            stackDelete.add(stackPush.pop())
        }
        return stackDelete.pop()
    }

}