package leetcode.produceConsume

import java.util.concurrent.locks.ReentrantLock

class PrinterRunnableLock(private val maxCount: Int) : Runnable {

    @Transient
    private val lock = ReentrantLock()
    private val cond = lock.newCondition()

    private var num = 0

    override fun run() {
        lock.lock()
        try {
            while (num < maxCount) {
                cond.signal()
                println("${Thread.currentThread().name} num ${++num}")
                cond.await()
            }
        } finally {
            lock.unlock()
        }
    }


    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val runnable = PrinterRunnableLock(40)
            Thread(runnable, "Thread-A").start()
            Thread(runnable, "Thread-B").start()
        }
    }

}