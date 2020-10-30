package com.zzh.Kotlin实战.chapter9_泛型

/**
 * @author zhangzhihao
 * @date 2020/10/28 15:32
 */

fun <T> List<T>.slice(indices: IntRange): List<T> {
    return this.filter { indexOf(it) in indices }.toList()
}

val <T> List<T>.penultimate: T get() = this[size - 2]

fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))

    println(listOf(1, 2, 3, 4).penultimate)
}