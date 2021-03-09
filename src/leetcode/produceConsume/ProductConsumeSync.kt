package leetcode.produceConsume

import java.util.concurrent.Executors

/**
 * 生产者消费者 synchronized 实现
 */
class ProductConsumeSync(private var MAX: Int) {
    private var count = 0

    private val lock = Object()

    fun produce() {
        synchronized(lock) {
            while (count == MAX) {
                lock.wait()
            }
            println("${Thread.currentThread().name} produce,count ${++count}")
            lock.notify()
        }
    }

    fun consume() {
        synchronized(lock) {
            while (count == 0) {
                lock.wait()
            }
            println("${Thread.currentThread().name} consume,count ${--count}")
            lock.notify()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val pool = ProductConsumeSync(30)
            val executor = Executors.newCachedThreadPool()
            for (i in 0 until 10) {
                executor.execute { pool.produce() }
                executor.execute { pool.consume() }
            }
        }
    }
}