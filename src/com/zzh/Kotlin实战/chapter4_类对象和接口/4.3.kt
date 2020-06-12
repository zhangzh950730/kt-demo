package com.zzh.Kotlin实战.chapter4_类对象和接口

/**
 * @author zhangzhihao
 * @date 2020/6/12 19:36
 */
fun main() {
    val client1 = Client("Alice", 342562)
    println(client1)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)

    val processed = hashSetOf<Client>(Client("alice", 342562))
    println(processed.contains(Client("Alice", 342562)))

    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))

}

class Client(val name: String, val postalCode: Int) {

    override fun toString(): String = "Client(name= $name , posttalCode = $postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) {
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode() = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)

}

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {

}