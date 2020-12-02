package com.zzh.Kotlin核心编程.chapter9_设计模式

import com.sun.org.apache.xpath.internal.operations.Bool
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.properties.Delegates

/**
 * @author zhangzhihao
 * @date 2020/11/29 16:18
 */
class StockUpdate {
    val listeners = mutableSetOf<StockUpdateListener>()
    var price: Int by Delegates.observable(0) { _, old, new ->
        listeners.forEach {
            if (new > old) it.onRise(price) else it.onFell(price)
        }
    }
}

interface StockUpdateListener {
    fun onRise(price: Int)
    fun onFell(price: Int)
}

class StockDisplay : StockUpdateListener {
    override fun onRise(price: Int) {
        println("The latest stock price has risen to $price")
    }

    override fun onFell(price: Int) {
        println("The latest stock price has fell to $price")
    }

}

var value: Int by Delegates.vetoable(0) { _, old, new -> new > 0 }

fun breaststorke() {
    println("I am breaststorking...")
}

fun backstorke() {
    println("I am backstorking...")
}

val freestyle = fun() {
    println("I am freestyle...")
}

class Swimmer(val swimming: () -> Unit) {
    fun swim() {
        swimming()
    }
}

data class Book(val name: String)
class Bookcase(val books: List<Book>)

operator fun Bookcase.iterator(): Iterator<Book> = object : Iterator<Book> {
    val iterator = books.iterator()
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): Book = iterator.next()
}

sealed class WaterMachineStatue(open val machine: WaterMachine) {
    fun turnHeating() {
        println("turnHeating")
        machine.state = machine.heating
    }

    fun turnCooling() {
        println("turnCooling")
        machine.state = machine.cooling
    }

    fun turnOff() {
        println("turnOff")
        machine.state = machine.off
    }
}

class Off(override val machine: WaterMachine) : WaterMachineStatue(machine)
class Heating(override val machine: WaterMachine) : WaterMachineStatue(machine)
class Cooling(override val machine: WaterMachine) : WaterMachineStatue(machine)

class WaterMachine {
    var state: WaterMachineStatue
    val off = Off(this)
    val heating = Heating(this)
    val cooling = Cooling(this)

    init {
        this.state = off
    }

    fun turnHeating() {
        this.state.turnHeating()
    }

    fun turnCooling() {
        this.state.turnCooling()
    }

    fun turnOff() {
        this.state.turnOff()
    }
}

enum class Moment {
    EARLY_MORNING,
    DRINKING_WATER,
    INSTANCE_NOODLES,
    AFTER_WORKER
}

fun waterMachineOps(machine: WaterMachine, moment: Moment) {
    when (moment) {
        Moment.EARLY_MORNING,
        Moment.DRINKING_WATER -> when (machine.state) {
            !is Cooling -> machine.turnCooling()
        }
        Moment.INSTANCE_NOODLES -> when (machine.state) {
            !is Heating -> machine.turnHeating()
        }
        Moment.AFTER_WORKER -> when (machine.state) {
            !is Off -> machine.turnOff()
        }
    }
}

fun main() {
    val su = StockUpdate()
    val sd = StockDisplay()
    su.listeners.add(sd)
    su.price = 100
    su.price = 98

    println("value = ${value}")
    value = 1
    println("value = ${value}")
    value = -1
    println("value = ${value}")

    val weekendShaw = Swimmer(freestyle)
    weekendShaw.swim()
    val weekdaysShaw = Swimmer(::breaststorke)
    weekdaysShaw.swim()

    val machine = WaterMachine()
    waterMachineOps(machine, Moment.DRINKING_WATER)
    waterMachineOps(machine, Moment.INSTANCE_NOODLES)
    waterMachineOps(machine, Moment.DRINKING_WATER)
    waterMachineOps(machine, Moment.AFTER_WORKER)
}

