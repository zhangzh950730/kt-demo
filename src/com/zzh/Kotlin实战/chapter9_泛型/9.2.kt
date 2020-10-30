package com.zzh.Kotlin实战.chapter9_泛型

/**
 * @author zhangzhihao
 * @date 2020/10/28 16:40
 */
inline fun <reified T> isA(value: Any) = value is T

val items = listOf("one", 2, "three")

fun main() {
    println(isA<String>("abc"))
    println(isA<String>(123))

    println(items.filterIsInstance<String>())
}