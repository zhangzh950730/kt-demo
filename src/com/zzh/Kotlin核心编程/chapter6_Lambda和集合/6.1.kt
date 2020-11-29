package com.zzh.Kotlin核心编程.chapter6_Lambda和集合

/**
 * @author zhangzhihao
 * @date 2020/11/26 8:57
 */

val sum: Int.(Int) -> Int = { other -> plus(other) }

class HTML {
    fun body() {
        println("body method")
    }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}

fun main() {
    val sum = 2.sum(1)
    println("sum = ${sum}")

    html {
        body()
    }
}