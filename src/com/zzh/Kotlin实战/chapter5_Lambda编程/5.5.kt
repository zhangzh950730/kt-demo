package com.zzh.Kotlin实战.chapter5_Lambda编程

import java.lang.StringBuilder

/**
 * @author zhangzhihao
 * @date 2020/10/28 13:40
 */

fun alphabet1() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    toString()
}

fun alphabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}.toString()

fun main() {
    var alphabet = alphabet1()
    println("alphabet = ${alphabet}")
    alphabet = alphabet2()
    println("alphabet = ${alphabet}")
}