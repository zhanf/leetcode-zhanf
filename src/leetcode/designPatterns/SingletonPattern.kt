package leetcode.designPatterns

object SingletonPattern {

    @JvmStatic
    fun main(array: Array<String>) {
        val instance = Singleton.getInstance()
    }
}

class Singleton private constructor() {

    companion object {
        private val instance2: Singleton by lazy {
            Singleton()
        }

        fun getInstance(): Singleton {
            return instance2
        }
    }

    fun function() {}
}