package com.zzh.Kotlin实战.chapter3_函数的定义与调用

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/3 22:44
 */
fun main(args: Array<String>) {
    val list = listOf("args: ", *args)
    println(list)
}

val list = listOf(1, 2, 3)

infix fun Any.to(other: Any) = Pair(this, other)