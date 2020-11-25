package com.zzh.Kotlin核心编程.chapter3_面向对象

/**
 * @author zhangzhihao
 * @date 2020/11/24 14:10
 */
data class Bird3(var weight: Double, var age: Int, var color: String)

data class Bird4(val weight: Double, val age: Int, val color: String)

fun main() {
    val b1 = Bird3(20.0, 1, "blue")
    val b2 = b1
    b2.age = 2
    println("b1 = ${b1}")
    println("b2 = ${b2}")

    val b3 = Bird4(20.0, 1, "blue")
    val b4 = b3.copy(age = 2)
    println("b3 = ${b3}")
    println("b4 = ${b4}")
}