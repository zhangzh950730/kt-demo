package com.zzh.Kotlin核心编程.chapter3_面向对象

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.swing.text.View
import kotlin.properties.Delegates

/**
 * @author zhangzhihao
 * @date 2020/11/20 8:52
 */
fun main() {
    val bird = Bird(500.0, 2, "blue")
    val sex = bird.sex
    println("sex = ${sex}")
    val sex1 = bird.sex1
    println("sex1 = ${sex1}")
}

class Bird(
    val weight: Double,
    val age: Int,
    val color: String
) {
    // val 属性的延迟初始化
    val sex: String by lazy {
        if (color == "yellow") "male" else "female"
    }

    // var 属性的延迟初始化,不能用于基本类型
    lateinit var sex1: String

    fun printSex() {
        sex1 = if (color == "yellow") "male" else "female"
        println(sex1)
    }

    // var 属性的延迟初始化,可以用于基本类型
    var test by Delegates.notNull<Int>()

    fun doSomething() {
        test = 1
        println("test = ${test}")
        test = 2
        println("test = ${test}")
    }
}
