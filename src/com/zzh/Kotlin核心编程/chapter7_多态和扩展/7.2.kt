package com.zzh.Kotlin核心编程.chapter7_多态和扩展

import com.zzh.Kotlin核心编程.chapter6_Lambda和集合.println

/**
 * @author zhangzhihao
 * @date 2020/11/26 13:59
 */
fun MutableList<Int>.exchange(fromIndex: Int, toIndex: Int) {
    val tmp = this[fromIndex]
    this[fromIndex] = this[toIndex]
    this[toIndex] = tmp
}

class Son {
    companion object {
        val age = 10
    }
}

fun Son.Companion.foo() {
    println("age = $age")
}

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        Son.foo()
    }
}

fun testFoo() {
    val nickName = "Prefert"
    run {
        val nickName = "YarenTang"
        println(nickName)
    }
    println(nickName)
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.println()
    list.exchange(1, 2)
    list.println()
}