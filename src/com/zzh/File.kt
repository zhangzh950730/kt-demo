package com.zzh

fun main() {
    fileSuffix()
}

fun fileSuffix() {
    var s = "s.mp4"
    val replaceFirst = s
        .replaceBefore(".", "")
        .replace(".", "")
    println(replaceFirst)

    s = "/home/intellitourism/projects/intellitourism/static/upload/2020/6/4/fkdlsjflsd.mp4"
    println(s.replaceBefore("upload", ""))
}