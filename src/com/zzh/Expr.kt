package com.zzh

import java.util.*

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/2 20:22
 */
interface Expr {

}

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun main() {
//    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

//    for (i in 1..100) {
//        print(fizzBuzz(i))
//    }
//
//    for (i in 100 downTo 1 step 2) {
//        print(fizzBuzz(i))
//    }

    demo()
}

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException()
        }

fun fizzBuzz(i: Int) =
        when {
            i % 15 == 0 -> "FizzBuzz "
            i % 3 == 0 -> "Fizz "
            i % 5 == 0 -> "Buzz "
            else -> "$i "
        }

fun demo() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}