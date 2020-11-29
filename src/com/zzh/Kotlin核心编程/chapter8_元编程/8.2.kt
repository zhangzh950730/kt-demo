package com.zzh.Kotlin核心编程.chapter8_元编程

import kotlin.reflect.KProperty
import kotlin.reflect.full.memberProperties

/**
 * @author zhangzhihao
 * @date 2020/11/29 9:12
 */
fun <A : Any> toMap(a: A) =
    a::class.memberProperties.map { m ->
        val p = m as KProperty<*>
        p.name to p.call(a)
    }.toMap()