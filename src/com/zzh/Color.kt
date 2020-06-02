package com.zzh

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/2 19:58
 */
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b

}

fun main() {
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
}

fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.BLUE -> "Battle"
        }

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.BLUE) -> Color.ORANGE
            else -> throw Exception("Dirty color")
        }