package leetcode.produceConsume

import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock

/**
 * 生产者消费者 lock 实现
 */
class ProductConsumeLock {

    private val lock = ReentrantLock(true)
    private val prod = lock.newCondition()
    private val cons = lock.newCondition()
    private var count = 0
    private val arrays = Array<Any?>(10) { it }

    fun produce(obj: Any) {
        lock.lock()
        try {
            while (count >= arrays.size) {
                prod.await()
            }
            arrays[count++] = obj
            println("${Thread.currentThread().name} produce $obj produce count: $count")
            cons.signal()
        } finally {
            lock.unlock()
        }
    }

    fun consume(): Any? {
        lock.lock()
        try {
            while (count <= 0) {
                cons.await()
            }
            val obj = arrays[--count]
            arrays[count] = null
            println("${Thread.currentThread().name} consume $obj consume count: $count")
            prod.signal()
            return obj
        } finally {
            lock.unlock()
        }
    }

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val pool = ProductConsumeLock()
            val executors = Executors.newCachedThreadPool()
            for (i in 0 until 30) {
                executors.execute {
                    pool.produce(Object())
                }
                executors.execute {
                    pool.consume()
                }
            }
        }
    }
}