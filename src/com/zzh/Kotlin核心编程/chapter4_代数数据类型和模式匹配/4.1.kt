package com.zzh.Kotlin核心编程.chapter4_代数数据类型和模式匹配

/**
 * @author zhangzhihao
 * @date 2020/11/24 15:44
 */
sealed class Day {
    class SUN : Day()
    class MON : Day()
    class TUE : Day()
    class WED : Day()
    class THU : Day()
    class FRI : Day()
    class SAT : Day()
}

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}

fun getArea(shape: Shape): Double = when (shape) {
    is Shape.Circle -> Math.PI * shape.radius * shape.radius
    is Shape.Rectangle -> shape.width * shape.height
    is Shape.Triangle -> shape.base * shape.height / 2.0
}

