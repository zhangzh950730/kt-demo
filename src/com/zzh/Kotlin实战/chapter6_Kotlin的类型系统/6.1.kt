package com.zzh.Kotlin实战.chapter6_Kotlin的类型系统

import jdk.nashorn.internal.objects.NativeUint16Array
import java.lang.IllegalArgumentException

/**
 * @author zhangzhihao
 * @date 2020/6/14 10:57
 */
fun main() {
//    strLen(null)

    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val address = Address("streetAddress", 423423, "city", "country")
    val company = Company("company", address)
    val person = Person("Dmitry", company)
    println(person.countryName())

    printShippingLabel(person)

//    ignoreNulls(null)

    var email: String? = "fsdjfdks@qq.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
}

//fun strLen(s: String?) = s.length

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String = this.company?.address?.country ?: "Unknown"

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city $country")
    }
}

class Person1(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person1 ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}