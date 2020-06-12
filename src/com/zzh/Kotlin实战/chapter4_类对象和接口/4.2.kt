package com.zzh.Kotlin实战.chapter4_类对象和接口

/**
 * @author zhangzhihao
 * @date 2020/6/12 12:39
 */

open class User(
    val nickname: String,
    val isSubsribed: Boolean = true
)

class TwitterUser(nickname: String) : User(nickname) {

}

open class Button42

class RadioButton : Button42()

class Secretive private constructor()

interface User1 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User1

class SubscribingUser(val email: String) : User1 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FackbookUser(val accountId: Int) : User1 {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface User2 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class User3(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name:"$field"->"$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val alice = User("Alice")
    println(alice.isSubsribed)

    val bob = User("Bob", false)
    println(bob.isSubsribed)

    val carol = User("Carol", isSubsribed = false)
    println(carol.isSubsribed)

    println(PrivateUser("test@kotlinglang.org").nickname)
    println(SubscribingUser("test@kotlinglang.org").nickname)

    val user = User3("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
    println(user)

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}

