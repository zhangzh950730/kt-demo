package com.zzh.Kotlin实战.chapter7_运算符重载及其他约定

import java.time.LocalDate

/**
 * @author zhangzhihao
 * @date 2020/10/27 15:09
 */
fun main() {
    val start = LocalDate.now()
    val vacation = start..start.plusDays(10)
    println(start.plusWeeks(2) in vacation)
}