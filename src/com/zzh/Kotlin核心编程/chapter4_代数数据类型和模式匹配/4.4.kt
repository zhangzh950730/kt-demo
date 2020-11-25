package com.zzh.Kotlin核心编程.chapter4_代数数据类型和模式匹配

/**
 * @author zhangzhihao
 * @date 2020/11/25 14:00
 */
sealed class Coupon {
    companion object {
        val CashType = "CASH"
        val DiscountType = "DISCOUNT"
        val GiftType = "GIFT"

        val NotFetched = 1 //未领取
        val Fetched = 2 //已领取但未使用
        val Used = 3 //已使用
        val Expired = 4 //已过期
        val UnAvilable = 5 //已失效
    }

    class CashCoupon(val id: Long, val type: String, val leastCost: Long, val reduceCost: Long) : Coupon()
    class DiscountCoupon(val id: Long, val type: String, val discount: Int) : Coupon()
    class GiftCoupon(val id: Long, val type: String, val gift: String) : Coupon()
}

sealed class CouponStatus{

}