package com.zzh.Kotlin核心编程.chapter2_基础语法

/**
 * @author zhangzhihao
 * @date 2020/11/19 14:29
 */
fun main() {
    val arrays = listOf(1, 2, 3)
    var res = cal1(arrays)
    println("arrays = ${arrays}")
    println("res = ${res}")

    res = cal2(arrays)
    println("arrays = ${arrays}")
    println("res = ${res}")

    res = cal3(arrays)
    println("arrays = ${arrays}")
    println("res = ${res}")
}

fun cal1(list: List<Int>): Int {
    var res = 0
    for (el in list) {
        res *= el
        res += el
    }
    return res
}

fun cal2(list: List<Int>): Int {
    fun recurse(listr: List<Int>, res: Int): Int {
        if (listr.size > 0) {
            val el = listr.first()
            return recurse(listr.drop(1), res * el + el)
        } else {
            return res
        }
    }
    return recurse(list, 0)
}

fun cal3(list: List<Int>): Int {
    return list.fold(0) { res, el -> res * el + el }
}