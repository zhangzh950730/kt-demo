package com.zzh.Kotlin实战.chapter10_注解与反射

/**
 * @author zhangzhihao
 * @date 2020/10/29 11:53
 */

data class Person(val name: String, val age: Int)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

annotation class JsonName(val name: String)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding


fun main() {
    val person = Person("Alice", 29)
    println()
}