package com.zzh

fun main(args: Array<String>) {
//    println("Hello World")
    println(max(1, 2))

    val answer: Int
    answer = 42

    val name = if (args.size > 0) args[0] else "kotlin"
    println(name)
    println("Hello, $name!")
}

fun max(a: Int, b: Int) = if (a > b) a else b

val question = "the"



