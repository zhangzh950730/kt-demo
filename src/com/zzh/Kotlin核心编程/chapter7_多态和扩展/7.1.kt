package com.zzh.Kotlin核心编程.chapter7_多态和扩展

/**
 * @author zhangzhihao
 * @date 2020/11/26 11:42
 */
data class Area(val value: Double)

operator fun Area.plus(that: Area): Area {
    return Area(this.value + that.value)
}

fun main() {
    println(Area(1.0) + Area(2.0))
}