package com.zzh.Kotlin实战.chapter3_函数的定义与调用

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/3 22:26
 */
fun main() {
    println("Kotlin".lastChar())
    val list = arrayListOf(1, 2, 3)
    println(list.joinToString(" "))
}

fun String.lastChar(): Char =
        this.get(this.length - 1)

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "")
        : String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

val String.lastChar: Char
    get() = get(length - 1)