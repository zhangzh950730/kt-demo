package com.zzh.Kotlin核心编程.chapter11_异步和并发

import kotlin.coroutines.*

/**
 * @author zhangzhihao
 * @date 2020/12/3 9:47
 */
class Shop {
    val goods = hashMapOf<Long, Int>()

    init {
        goods.put(1, 10)
        goods.put(2, 15)
    }

    @Synchronized
    fun buyGoods(id: Long) {
        val stock = goods.getValue(id)
        goods.put(id, stock - 1)
    }

    fun buyGoods2(id: Long) {
        synchronized(this) {
            val stock = goods.getValue(id)
            goods.put(id, stock - 1)
        }
    }
}
