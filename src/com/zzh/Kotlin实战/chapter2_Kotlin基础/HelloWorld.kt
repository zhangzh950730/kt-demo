package com.zzh.Kotlin实战.chapter2_Kotlin基础

fun main(args: Array<String>) {
//    println("Hello World")
    println(max(1, 2))

    val answer: Int
    answer = 42

    val name = if (args.size > 0) args[0] else "kotlin"
    println(name)
    println("Hello, $name!")

    if (args.size > 0) {
        println("hello, ${args[0]}!")

        println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
    }

    println(createRandomRectangle().isSquare)
}

fun max(a: Int, b: Int) = if (a > b) a else b

val question = "the"




