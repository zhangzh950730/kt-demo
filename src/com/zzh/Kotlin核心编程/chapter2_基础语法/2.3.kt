package com.zzh.Kotlin核心编程.chapter2_基础语法

/**
 * @author zhangzhihao
 * @date 2020/11/19 15:12
 */
fun main() {
    var sum = sum(1, 2, 3)
    println("sum = ${sum}")
    sum = sum(1)(2)(3)
    println("sum = ${sum}")
}

fun sum(x: Int, y: Int, z: Int) = x + y + z

fun sum(x: Int) = { y: Int ->
    { z: Int -> x + y + z }
}