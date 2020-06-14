package com.zzh.Kotlin实战.chapter7_运算符重载及其他约定

/**
 * @author zhangzhihao
 * @date 2020/6/14 15:41
 */

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}
