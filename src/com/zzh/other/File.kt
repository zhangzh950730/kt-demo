package com.zzh

import java.io.File
import java.sql.DriverManager
import java.util.HashMap

val map = HashMap<Long, ArrayList<String>>()

fun main() {

//    fileSuffix()
    fileMove()

    val connection = DriverManager.getConnection(
        "jdbc:mysql://rm-bp1434v0c243qdc29yo.mysql.rds.aliyuncs.com:3306/db_intellitourism?serverTimezone=Asia/Shanghai&useUnicode=true",
        "kuama", "AC885Rcz1V4LTtZ#E#m6A^!j\$!crvWCi"
    )

    for (mutableEntry in map) {
        val value = mutableEntry.value
        if (value.size > 1) {
            val sb = StringBuilder()
            for ((index, url) in value.withIndex()) {
                sb.append("'")
                sb.append(url)
                sb.append("'")
                if (index != value.size - 1) {
                    sb.append(",")
                }
            }

            val createStatement = connection.createStatement()
            val sql = """
                SELECT id,entity_id, url 
                FROM t_abstract_static_resource
                WHERE url IN (${sb.toString().replace("\\", "/")})
                AND invalid = 0 AND type = 'Video'
            """.trimIndent()
            val rs = createStatement.executeQuery(sql)
            while (rs.next()) {
                val id = rs.getInt("id")
                val entityId = rs.getInt("entity_id")
                val url = rs.getString("url")
                print("entityId = ${entityId} ")
                print("id = ${id} ")
                println("url = ${url}")
            }
            println("==================")
        }
    }
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

fun fileMove() {
    val source = File("D:/static")
    scan(source)
}

fun scan(source: File) {
    if (source.isDirectory) {
        val listFiles = source.listFiles()
        if (listFiles.isNullOrEmpty().not()) {
            listFiles?.forEach { scan(it) }
        }
    } else {
        if (!source.name.endsWith(".jpg")) {
            val size = source.length()
            var files = map.get(size)
            if (files.isNullOrEmpty()) {
                files = ArrayList()
                map.put(size, files)
            }
            files.add(source.canonicalPath.replace("D:\\static", "upload"))
        }
    }
}
