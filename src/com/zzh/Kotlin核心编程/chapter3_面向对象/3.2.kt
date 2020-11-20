package com.zzh.Kotlin核心编程.chapter3_面向对象

/**
 * @author zhangzhihao
 * @date 2020/11/20 9:43
 */
sealed class Bird1 {
    open fun fly() = "i can fly"
    class Eagle : Bird1()
}