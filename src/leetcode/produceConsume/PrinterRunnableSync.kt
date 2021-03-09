package leetcode.produceConsume

/**
 * 两线程交替打印数字
 */
class PrinterRunnableSync(private val maxCount: Int) : Runnable {

    @Transient
    private val lock = Object()
    private var count = 0

    override fun run() {
        synchronized(lock) {
            while (count < maxCount) {
                lock.notify()
                println("${Thread.currentThread().name} count ${++count}")
                lock.wait()
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            val runnable = PrinterRunnableSync(20)
            Thread(runnable, "Thread --A").start()
            Thread(runnable, "Thread --B").start()
        }
    }
}