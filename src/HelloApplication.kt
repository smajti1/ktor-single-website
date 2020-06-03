package io.ktor.samples.hello

import com.mitchellbosecke.pebble.loader.ClasspathLoader
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.pebble.*

fun Application.main() {
    initDB()
    install(DefaultHeaders)
    install(CallLogging)
    install(Pebble) {
        loader(ClasspathLoader().apply {
            prefix="templates/"
            suffix=".pebble"
        })
    }
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Ktor: jetty" }
                }
                body {
                    p {
                        +"Hello from Ktor Jetty engine sample application :)"
                    }
                }
            }
        }
        get("/test") {
            call.respondText(getTopFiveUserData(), ContentType.Text.Plain)
        }
        get("/hello") {
            val queryParameters: Parameters = call.request.queryParameters
            val userId: Int? = queryParameters["user_id"]?.toIntOrNull()
            val map = mutableMapOf<String, Any>()
            if (userId != null) {
                val user = getUserById(userId)
                if (user != null) {
                    map["user"] = user
                }
            }

            call.respond(PebbleContent("hello", map))
        }
    }
}