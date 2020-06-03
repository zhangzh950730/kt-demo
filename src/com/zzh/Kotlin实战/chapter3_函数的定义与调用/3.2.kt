package com.zzh.Kotlin实战.chapter3_函数的定义与调用

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/3 22:05
 */
fun main() {
    val list = listOf(1, 2, 3)
//    println(joinToString(list, "; ", "(", ")"))
    println(joinToString(list, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(list))
    println(joinToString(list, ";"))
    println(joinToString(list, prefix = "(", postfix = ")"))

}

fun <T> joinToString(collection: Collection<T>,
                     separator: String = ",",
                     prefix: String = "",
                     postfix: String = "")
        : String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0;
fun performOperation(){
    opCount++;
}

fun reportOperationCount(){
    println("Operation performed $opCount times")
}

const val UNIX_LINE_SEPARATOR = "\n"
