package io.ktor.samples.hello

import com.google.gson.Gson
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object User : Table("user") {
    val id = integer("id")
    val name = varchar("name", length=50)
    val email = varchar("email", length=50)
}

data class Users(val id: Int, val name: String, val email: String)

fun initDB() {
    val env: MutableMap<String, String> = System.getenv()
    val url = "jdbc:mysql://${env["DB_USERNAME"]}:${env["DB_PASSWORD"]}@${env["DB_HOST"]}:${env["DB_PORT"]}/${env["DB_DATABASE"]}?useUnicode=true&serverTimezone=UTC&useSSL=false"
    val driver = "com.mysql.cj.jdbc.Driver"
    Database.connect(url, driver)
}

fun getTopFiveUserData(): String {
    var json = ""
    transaction {
        val res = User.selectAll().orderBy(User.id, false).limit(5)
        val c = ArrayList<Users>()
        for (f in res) {
            c.add(Users(id = f[User.id], name = f[User.name], email = f[User.email]))
        }
        json = Gson().toJson(c)
    }
    return json
}

fun getUserById(userId: Int): Users? {
    var user: Users? = null
    transaction {
        val result = User.select { User.id.eq(userId) }.firstOrNull()
        if (result != null) {
            user = Users(id = result[User.id], name = result[User.name], email = result[User.email])
        }
    }
    return user
}