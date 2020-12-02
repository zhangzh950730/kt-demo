package com.zzh.Kotlin核心编程.chapter10_函数式编程

import kotlin.collections.List

/**
 * @author zhangzhihao
 * @date 2020/12/1 8:44
 */
sealed class Format

data class Print(val text: String) : Format()
object Newline : Format()

val string = listOf<Format>(Print("Hello"), Newline, Print("Kotlin"))

fun unsafeInterpreter(str: kotlin.collections.List<Format>) {
    str.forEach {
        when (it) {
            is Print -> println(it.text)
            is Newline -> println()
        }
    }
}

fun unsafeInterpreter1(str: List<Format>) =
    str.fold("") { fullText, s ->
        when (s) {
            is Print -> fullText + s.text
            is Newline -> fullText + "\n"
        }
    }

fun main() {
    unsafeInterpreter(string)
    println("===")
    println(unsafeInterpreter1(string))
}
