package com.zzh.Kotlin实战.chapter11_DSL构建

/**
 * @author zhangzhihao
 * @date 2020/10/30 9:58
 */
data class Issue(val id: String, val project: String, val type: String, val priority: String, val description: String)

class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }

    private fun Issue.isImportant(): Boolean {
        return type == "Bug" && (priority == "Major" || priority == "Critical")
    }
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}

fun main() {
    val i1 = Issue("IDEA-154446", "IDEA", "Bug", "Major", "Save settings failed")
    val i2 = Issue("KT-12183", "Kotlin", "Feature", "Normal", "...")
    val predicate = ImportantIssuesPredicate("IDEA")
    for (issue in listOf(i1, i2).filter(predicate)) {
        println(issue.id)
    }

    val dependencies = DependencyHandler()
    dependencies.compile("kotlin-core")
    dependencies {
        compile("kotlin-reflect")
    }
}