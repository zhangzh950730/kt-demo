package com.zzh.Kotlin核心编程.chapter5_类型系统

import java.lang.IndexOutOfBoundsException

/**
 * @author zhangzhihao
 * @date 2020/11/25 14:21
 */
data class Seat(val student: Student?)

data class Student(val glasses: Glasses?)
data class Glasses(val degreeOfMyopia: Int)

fun <T> copyIn(dest: Array<in T>, src: Array<T>) {
    if (dest.size < src.size) {
        throw IndexOutOfBoundsException()
    } else {
        src.forEachIndexed { index, value -> dest[index] = src[index] }
    }
}

fun <T> copyOut(dest: Array<T>, src: Array<out T>) {
    if (dest.size < src.size) {
        throw IndexOutOfBoundsException()
    } else {
        src.forEachIndexed { index, value -> dest[index] = src[index] }
    }
}

fun main() {
    val stu = Student(null)
    val result = stu.glasses?.degreeOfMyopia ?: -1

    val src = arrayOf(1.0, 2.0, 3.0)
    val dest1 = arrayOfNulls<Number>(3)
    val dest2 = arrayOfNulls<Number>(3)
    copyIn(dest1, src)
    copyOut(dest2, src)
    src.arrayPrint()
    dest1.arrayPrint()
    dest2.arrayPrint()
}

fun <T> Array<T>.arrayPrint() {
    this.forEach {
        print("$it ")
    }
    println()
}