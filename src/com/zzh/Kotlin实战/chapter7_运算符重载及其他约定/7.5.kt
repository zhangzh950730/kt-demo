package com.zzh.Kotlin实战.chapter7_运算符重载及其他约定

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * @author zhangzhihao
 * @date 2020/10/27 15:31
 */


class Email

private fun loadEmails(person: Any): List<Email> {
    return listOf(Email())
}

@Deprecated("见Person2实现")
class Person1(val name: String) {
    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }
}

class Person2(val name: String) {
    val emails by lazy { loadEmails(this) }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    val age: Int by ObservableProperty(age, changeSupport)
    val salary: Int by ObservableProperty(salary, changeSupport)
}

class ObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
    fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

fun main() {
    val p = Person("Dmitry", 34, 2000)
    p.addPropertyChangeListener(PropertyChangeListener { evt ->
        println("property ${evt.propertyName} changed from ${evt.oldValue} to ${evt.newValue}")
    })
}