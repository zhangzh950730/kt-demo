package com.zzh.Kotlin核心编程.chapter3_面向对象

/**
 * @author zhangzhihao
 * @date 2020/11/24 13:48
 */

class OuterKotlin {
    val name = "This is truely Kotlin's inner class syntax"

    inner class InnerKotlin {
        fun printName() {
            print("the name is $name")
        }
    }
}

open class Horse {
    fun runFast() {
        println("I can run fase")
    }
}

open class Donkey {
    fun doLongTimeThing() {
        println("I can do some thing long time")
    }
}

class Mule {
    fun runFast() {
        HorseC().runFast()
    }

    fun doLongTimeThing() {
        DonkeyC().doLongTimeThing()
    }

    private inner class HorseC : Horse()
    private inner class DonkeyC : Donkey()
}

interface CanFly {
    fun fly()
}

interface canEat {
    fun eat()
}

open class Flyer : CanFly {
    override fun fly() {
        println("I can fly")
    }
}

open class Animal : canEat {
    override fun eat() {
        println("I can eat")
    }
}

class Bird2(flyer: Flyer, animal: Animal) : CanFly by flyer, canEat by animal {
}

fun main() {
    val flyer = Flyer()
    val animal = Animal()
    val b = Bird2(flyer, animal)
    b.fly()
    b.eat()
}