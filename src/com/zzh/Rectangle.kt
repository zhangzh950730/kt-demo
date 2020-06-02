package com.zzh

import java.util.*


/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/2 19:48
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}