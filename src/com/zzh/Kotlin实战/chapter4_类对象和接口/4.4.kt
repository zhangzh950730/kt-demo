package com.zzh.Kotlin实战.chapter4_类对象和接口

import com.sun.org.apache.bcel.internal.generic.NEW
import com.zzh.Kotlin实战.chapter2_Kotlin基础.Person
import sun.plugin2.os.windows.Windows
import java.io.File

/**
 * @author zhangzhihao
 * @date 2020/6/12 19:58
 */
fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf<File>(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    println(A.bar())

    println(User4.newSubscribingUser("bob@gmail.com"))
    println(User4.newFacebookUser(4))

    println(Person1.loader.fromJson("{name : dmitry}"))
    println(Person1.fromJson("{name : dmitry}"))
}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            TODO()
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }

}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class User4 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User4(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) = User4(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String {
            return accountId.toString()
        }
    }

}

data class Person1(val name: String) {
    companion object loader {
        fun fromJson(jsonText: String) = Person1(name = jsonText)
    }
}