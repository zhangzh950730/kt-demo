package com.zzh.Kotlin核心编程.chapter10_函数式编程

/**
 * @author zhangzhihao
 * @date 2020/12/1 8:58
 */

interface Kind<out F, out A>

interface Functor<F> {
    fun <A, B> Kind<F, A>.map(f: (A) -> B): Kind<F, B>
}

sealed class List<out A> : Kind<List.K, A> {
    object K
}

data class Cons<A>(val head: A, val tail: List<A>) : List<A>()

interface Eq<F> {
    fun F.eq(that: F): Boolean
}

object IntEq : Eq<Int> {
    override fun Int.eq(that: Int): Boolean {
        return this == that
    }
}

abstract class ListEq<A>(val a: Eq<A>) : Eq<Kind<List.K, A>> {

}

fun main() {
    IntEq.run {
        val a = 1
        println(a.eq(1))
        println(a.eq(2))
    }
}