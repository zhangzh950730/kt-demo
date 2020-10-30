package com.zzh.Kotlin实战.chapter11_DSL构建

import java.time.LocalDate
import java.time.Period

/**
 * @author zhangzhihao
 * @date 2020/10/30 10:34
 */
interface Matcher<T> {
    fun test(value: T)
}

class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (value.startsWith(prefix).not()) {
            throw AssertionError("String $value does not start with $prefix")
        }
    }
}

class lessThan(val number: Int) : Matcher<Int> {
    override fun test(value: Int) {
        if (value > number) {
            throw AssertionError("Number $value does not lessThan $number")
        }
    }
}

infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun main() {
    val s = "kotlin"
    s should startWith("kot")
    val i = 1
    i should lessThan(10)

    val days = 1.days
    println(days.ago)
    println(days.fromNow)
}