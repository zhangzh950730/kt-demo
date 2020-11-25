package com.zzh.Kotlin核心编程.chapter4_代数数据类型和模式匹配

/**
 * @author zhangzhihao
 * @date 2020/11/25 9:52
 */
sealed class Expr {
    abstract fun isZero(v: Visitor): Boolean
    abstract fun isAddZero(v: Visitor): Boolean
    abstract fun simplifyExpr(v: Visitor): Expr

    class Num(val value: Int) : Expr() {
        override fun isZero(v: Visitor) = v.matchZero(this)
        override fun isAddZero(v: Visitor) = v.matchAddZero(this)
        override fun simplifyExpr(v: Visitor) = v.doSimplifyExpr(this)
    }

    class Operate(val opName: String, val left: Expr, val right: Expr) : Expr() {
        override fun isZero(v: Visitor) = v.matchZero(this)
        override fun isAddZero(v: Visitor) = v.matchAddZero(this)
        override fun simplifyExpr(v: Visitor) = this
    }
}

class Visitor {
    fun matchAddZero(expr: Expr.Num): Boolean = false
    fun matchAddZero(expr: Expr.Operate): Boolean = when (expr) {
        Expr.Operate("+", Expr.Num(0), expr.right) -> true
        Expr.Operate("+", expr.left, Expr.Num(0)) -> true
        else -> false
    }

    fun matchZero(expr: Expr.Num): Boolean = expr.value == 0
    fun matchZero(expr: Expr.Operate): Boolean = false

    fun doSimplifyExpr(expr: Expr.Num): Expr = expr
}