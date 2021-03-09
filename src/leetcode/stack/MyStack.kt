package leetcode.stack

class MyStack<T> {

    private val list = mutableListOf<T?>()

    fun push(x: T?) {
        list.add(0, x)
    }

    fun pop(): T? {
        return when (list.size) {
            0 -> null
            else -> list.removeAt(0)
        }
    }

    fun top(): T? {
        return when (list.size) {
            0 -> null
            else -> list[0]
        }
    }

    fun empty(): Boolean {
        return list.size <= 0
    }
}