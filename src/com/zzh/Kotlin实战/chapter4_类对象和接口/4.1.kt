package com.zzh.Kotlin实战.chapter4_类对象和接口

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/5 20:46
 */

interface Clickable {
    fun click();
    fun showOff() = println("I am clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I am focusable!")
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.setFocus(false)
    button.click()
}

open class RichButton : Clickable {

    fun disable() {

    }

    open fun animate() {

    }

    final override fun click() {

    }
}

abstract class Animated {
    abstract fun animate()

    open fun stopAnimating() {

    }

    fun animateTwice() {

    }
}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let*s talk!")
}

//fun TalkativeButton.giveSpeech(){
//    yell()
//    whisper()
//}