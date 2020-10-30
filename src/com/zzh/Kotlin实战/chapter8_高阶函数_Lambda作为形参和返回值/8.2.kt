package com.zzh.Kotlin实战.chapter8_高阶函数_Lambda作为形参和返回值

import java.util.concurrent.locks.Lock

/**
 * @author zhangzhihao
 * @date 2020/10/28 13:53
 */
inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")
}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}

fun main() {

}