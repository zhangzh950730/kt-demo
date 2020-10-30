package com.zzh.Kotlin实战.chapter11_DSL构建

/**
 * @author zhangzhihao
 * @date 2020/10/30 8:51
 */

fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString1(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString() = "<$name>${children.joinToString("")}<$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)
class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}
class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}
class TD : Tag("td")
fun createTable() = table {
    tr {
        td {
        }
    }
}

fun main() {
    var s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    s = buildString1 {
        this.append("Hello, ")
        append("World!")
    }
    println(s)

    println(createTable())
}