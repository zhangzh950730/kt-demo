package com.zzh.Kotlin实战.chapter6_Kotlin的类型系统

/**
 * @author zhangzhihao
 * @date 2020/6/14 14:26
 */

val i = 1
val l: Long = i.toLong()

fun foo(l: Long) = println(l)

fun main() {
    val x = 1
    val list = listOf(1L, 2L, 3L)
    println(x.toLong() in list)

    val b: Byte = 1
    val l = b + 1L
    foo(l)
    foo(42)

}