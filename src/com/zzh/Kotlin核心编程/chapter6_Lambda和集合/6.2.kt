package com.zzh.Kotlin核心编程.chapter6_Lambda和集合

/**
 * @author zhangzhihao
 * @date 2020/11/26 9:06
 */
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val newList = list.map { it * 2 }
    newList.println()
}

fun <T> List<T>.println() {
    this.forEach {
        print("$it ")
    }
    kotlin.io.println()
}