package leetcode.queue

import java.util.*
import kotlin.math.max

class MaxQueue {
    var origins = LinkedList<Int>()
    var maxs = LinkedList<Int>()
    fun max_value(): Int {
        return if (maxs.isEmpty()) -1 else maxs.first
    }

    fun push_back(value: Int) {
        origins.add(value)
        while(!maxs.isEmpty() && maxs.last<value){
            maxs.removeLast()
        }
        maxs.add(value)
    }

    fun pop_front(): Int {
        if (!maxs.isEmpty() && maxs.first == origins.peek()) {
            maxs.removeFirst()
        }
        return if (origins.isEmpty()) -1 else origins.poll()
    }
}