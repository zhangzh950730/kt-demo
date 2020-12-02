package com.zzh.Kotlin核心编程.chapter9_设计模式

/**
 * @author zhangzhihao
 * @date 2020/11/29 14:36
 */
interface Computer {
    val cpu: String

    companion object Factory {
        operator fun invoke(type: ComputerType): Computer {
            return when (type) {
                ComputerType.PC -> PC()
                ComputerType.Server -> Server()
            }
        }
    }
}

class PC(override val cpu: String = "Core") : Computer
class Server(override val cpu: String = "Xeon") : Computer

enum class ComputerType {
    PC, Server
}

object ComputerFactory {
    operator fun invoke(type: ComputerType): Computer {
        return when (type) {
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

fun Computer.Factory.fromCPU(cpu: String): ComputerType? = when (cpu) {
    "Core" -> ComputerType.PC
    "Xeon" -> ComputerType.Server
    else -> null
}

class Dell(override val cpu: String = "Core") : Computer
class Asus(override val cpu: String = "Core") : Computer
class Acer(override val cpu: String = "Core") : Computer

abstract class AbstractFactory {
    abstract fun product(): Computer

    companion object {
        inline operator fun <reified T : Computer> invoke(): AbstractFactory = when (T::class) {
            Dell::class -> DellFactory()
            Asus::class -> AsusFactory()
            Acer::class -> AcerFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

class DellFactory : AbstractFactory() {
    override fun product() = Dell()
}

class AsusFactory : AbstractFactory() {
    override fun product() = Asus()
}

class AcerFactory : AbstractFactory() {
    override fun product() = Acer()
}

class Robot(
    val code: String
    , val battery: String? = null
    , val height: Int? = null
    , val weight: Int? = null
) {
    init {
        require(weight == null || battery != null) {
            "Battery should be determined when setting weight."
        }
    }
}


fun main() {
    // 工厂
    var computer = ComputerFactory(ComputerType.PC)
    println(computer.cpu)
    // 伴生对象
    computer = Computer(ComputerType.PC)
    println(computer.cpu)
    // 伴生对象,带名字
    computer = Computer.Factory(ComputerType.PC)
    println(computer.cpu)

    val dellFactory = AbstractFactory<Dell>()
    val dell = dellFactory.product()
    println(dell)
    val robot = Robot(code = "007", weight = 100)
    println(robot)
}