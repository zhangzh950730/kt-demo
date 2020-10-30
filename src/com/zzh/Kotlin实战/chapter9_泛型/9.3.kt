package com.zzh.Kotlin实战.chapter9_泛型

import kotlin.reflect.KClass

/**
 * @author zhangzhihao
 * @date 2020/10/28 17:09
 */

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean {
        return input.isNotBlank()
    }
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean {
        return input >= 0
    }
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> {
        return validators[kClass] as? FieldValidator<T> ?: throw IllegalArgumentException("No ...")
    }
}


fun main() {
    printContents(listOf("abc", "bac"))

//    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings)
//    println(strings.maxBy { it.length })

    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    val stringValidator = validators[String::class] as FieldValidator<String>
    println(stringValidator.validate(""))
}