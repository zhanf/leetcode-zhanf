package leetcode.designPatterns

import java.lang.IllegalArgumentException

/**
 * 抽象工厂-创建型模式
 * 工厂的工厂(先理解 工厂模式)
 */
object AbstractFactoryPattern {

    @JvmStatic
    fun main(array: Array<String>) {
        val abstractFacFactory = AbstractFacFactory()
        val fruitFactory = abstractFacFactory.getAbstractFactory("_FruitFactory")
        val colorFactory = abstractFacFactory.getAbstractFactory("ColorFactory")
        fruitFactory.produceFruit("Apple")
        colorFactory.produceColor("Red")
    }
}

class AbstractFacFactory {
    fun getAbstractFactory(factoryName: String): AbstractFactory {
        return when (factoryName) {
            _FruitFactory::class.simpleName -> {
                _FruitFactory()
            }
            ColorFactory::class.simpleName -> {
                ColorFactory()
            }
            else -> {
                throw IllegalArgumentException("do not support AbstractFactory type")
            }
        }
    }
}

class _FruitFactory : AbstractFactory {
    override fun produceColor(color: String): Color {
        throw IllegalArgumentException("do not support color type")
    }

    override fun produceFruit(fruit: String): Fruit {
        return when (fruit) {
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

class ColorFactory : AbstractFactory {

    override fun produceColor(color: String): Color {
        return when (color) {
            Red::class.simpleName -> {
                Red()
            }
            Blue::class.simpleName -> {
                Blue()
            }
            else -> {
                throw IllegalArgumentException("do not support color type")
            }
        }
    }

    override fun produceFruit(fruitName: String): Fruit {
        throw IllegalArgumentException("do not support fruit type")
    }

}

interface AbstractFactory {
    fun produceColor(color: String): Color
    fun produceFruit(fruit: String): Fruit
}

interface Color {
    fun fill()
}

class Red : Color {
    override fun fill() {
        println("Red")
    }
}

class Blue : Color {
    override fun fill() {
        println("Blue")
    }
}