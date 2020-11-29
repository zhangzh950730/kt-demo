package com.zzh.Kotlin核心编程.chapter8_元编程

/**
 * @author zhangzhihao
 * @date 2020/11/29 9:55
 */
annotation class Cache(val namespace: String, val expires: Int)

annotation class CacheKey(val keyName: String, val buckets: IntArray)

@Cache(namespace = "hero", expires = 3600)
data class Hero(
    @CacheKey(keyName = "heroName", buckets = [1, 2, 3])
    val name: String
    , val attack: Int
    , val defense: Int
    , val initHp: Int
)