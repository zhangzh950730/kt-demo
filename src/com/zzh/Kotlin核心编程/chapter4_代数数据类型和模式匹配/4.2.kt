package com.zzh.Kotlin核心编程.chapter4_代数数据类型和模式匹配

import com.mysql.cj.x.protobuf.MysqlxExpr
import kotlin.math.exp

/**
 * @author zhangzhihao
 * @date 2020/11/24 17:22
 */

fun constantPattern(a: Int) = when (a) {
    1 -> "it is 1"
    2 -> "it is 2"
    else -> "it is other number $a"
}

fun logicPattern(a: Int) = when (a) {
    in 2..11 -> (a.toString() + " is smaller than 10 and bigger than 1")
    else -> "Maybe $a is bigger than 10, or smaller than 1"
}

fun logicPattern(a: String) = when {
    a.contains("Yison") -> "Something is about Yison"
    else -> "It is none of Yison's business"
}



fun simplifyExpr(expr: Expr): Expr = when (expr) {
    is Expr.Num -> expr
    is Expr.Operate -> when (expr) {
        Expr.Operate("+", Expr.Num(0), expr.right) -> expr.right
        Expr.Operate("+", expr.left, Expr.Num(0)) -> expr.left
        else -> expr
    }
}


fun main() {
    println(constantPattern(1))
    println(constantPattern(2))
    println(constantPattern(0))

    println(logicPattern(1))
    println(logicPattern(2))
    println(logicPattern(10))
    println(logicPattern(11))

    println(logicPattern("Yison is a good boy"))
    println(logicPattern("Jack is a good boy"))
}