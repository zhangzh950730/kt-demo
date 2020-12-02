package com.zzh.Kotlin核心编程.chapter10_函数式编程

/**
 * @author zhangzhihao
 * @date 2020/12/1 10:17
 */
interface Monoid<A> {
    fun zero(): A
    fun A.append(b: A): A
}

object stringConcatMonoid : Monoid<String> {
    override fun zero() = ""
    override fun String.append(b: String) = this + b
}
