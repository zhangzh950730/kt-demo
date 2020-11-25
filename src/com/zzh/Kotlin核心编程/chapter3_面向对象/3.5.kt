package com.zzh.Kotlin核心编程.chapter3_面向对象

/**
 * @author zhangzhihao
 * @date 2020/11/24 14:27
 */
class Prize(val name: String, val count: Int, val type: Int) {
    companion object {
        val TYPE_COMMON = 1
        val TYPE_REDPACK = 2
        val TYPE_COUPON = 3

        private val defaultCommonPrize = Prize("普通奖品", 10, TYPE_COMMON)
        fun newRedpackPrize(name: String, count: Int) = Prize(name, count, TYPE_REDPACK)
        fun newCouponPrize(name: String, count: Int) = Prize(name, count, TYPE_COUPON)
        fun defaultCommonPrize() = defaultCommonPrize
        fun isRedpack(prize: Prize): Boolean {
            return prize.type == TYPE_REDPACK
        }
    }
}

object DatabaseConfig {
    var host = "127.0.0.1"
    var port = 3306
    var username = "root"
    var password = ""
}

fun main() {
    val prize = Prize("红包", 10, Prize.TYPE_REDPACK)
    println(Prize.isRedpack(prize))

    val redpackPrize = Prize.newRedpackPrize("红包", 10)
    println("redpackPrize = ${redpackPrize}")
    val couponPrize = Prize.newCouponPrize("十元代金券", 10)
    println("couponPrize = ${couponPrize}")
    val commonPrize = Prize.defaultCommonPrize()
    println("commonPrize = ${commonPrize}")
}