package leetcode.designPatterns

import java.lang.IllegalArgumentException

/**
 * 工厂模式-创建型模式
 *
 * 屏蔽产品的具体实现，调用者只关心产品的接口
 * 扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 *
 * 使用场景：
 *  1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
 *  2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
 *  3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。
 */

object FactoryPattern {

    @JvmStatic
    fun main(array: Array<String>) {
        val factory = FruitFactory()
        val fruit1 = factory.produceFruit("Apple")
        val fruit2 = factory.produceFruit("Banana")
        fruit1.shape()
        fruit2.shape()
    }
}

class FruitFactory {

    fun produceFruit(fruitName: String): Fruit {
        return when (fruitName) {
            Apple::class.simpleName -> {
                Apple()
            }
            Banana::class.simpleName -> {
                Banana()
            }
            else -> {
                throw IllegalArgumentException("do not support fruit type")
            }
        }
    }
}

interface Fruit {
    fun shape()
}

class Apple : Fruit {
    override fun shape() {
        println("Apple")
    }
}

class Banana : Fruit {
    override fun shape() {
        println("Banana")
    }
}