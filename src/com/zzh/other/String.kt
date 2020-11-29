package com.zzh

import kotlin.math.pow

/**
 * @author zhangzhihao
 * @date 2020/9/22 14:39
 */


private val alphabet = arrayOf(
    'd'
    , 'r'
    , 'h'
    , 'b'
    , 'a'
    , 'j'
    , 'e'
    , 'w'
    , 'g'
    , 'l'
    , 'm'
    , 'n'
    , 'i'
    , 'o'
    , 'y'
    , 'p'
    , 'k'
    , 'q'
    , 'c'
    , 's'
    , 't'
    , 'u'
    , 'z'
    , 'v'
    , 'f'
    , 'x'
)

/**
 * 根据用户id,生成其邀请码
 */
fun createInviteCode(userId: Long): String {
    var uid = if (userId < 100000000L) {
        // 弥补早期注册的用户id过小的问题
        // 如果用户id小于一亿,则该用户是旧用户的id,以int的最大值减去其id作为id
        Int.MAX_VALUE - userId
    } else {
        userId
    }

    // 将id以十进制映射成26进制后,以数字作为索引去取字母表的内容
    var result = ""
    while (uid != 0L) {
        val i = uid % 26
        val c = alphabet[i.toInt()]
        result = c + result
        uid /= 26
    }
    return result
}

/**
 * 根据邀请码,解出所属的用户id
 */
fun deInviteCode(code: String): Long {
    // 颠倒邀请码
    val uCode = code.reversed()
    var result = 0.0
    var pow = 0.0
    // 根据字母表,反推出26进制的数字,然后转化为10进制的id
    for (c in uCode) {
        for ((i, a) in alphabet.withIndex()) {
            if (a == c) {
                result += i * 26.0.pow(pow++)
            }
        }
    }
    // 28是因为生产库的前28位id到28,后面的是一亿起
    if (result >= Int.MAX_VALUE - 28) {
        result = Int.MAX_VALUE - result
    }
    return result.toLong()
}

fun main() {
//    for (i in 100000000L..101000000L) {
//        val inviteCode = createInviteCode(i)
//        println("$i : $inviteCode")
//    }

    val deInviteCode = deInviteCode("gmupjy")
    println("deInviteCode = ${deInviteCode}")

}