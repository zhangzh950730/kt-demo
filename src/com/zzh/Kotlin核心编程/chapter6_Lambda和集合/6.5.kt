package com.zzh.Kotlin核心编程.chapter6_Lambda和集合

/**
 * @author zhangzhihao
 * @date 2020/11/26 10:41
 */

fun main() {
    foo {
        println("dive into kotlin...")
    }
}

inline fun foo(block: () -> Unit) {
    println("before block")
    block()
    println("end block")
}