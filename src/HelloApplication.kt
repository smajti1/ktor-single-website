package io.ktor.samples.hello

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import io.ktor.http.ContentType

fun Application.main() {
    initDB()
    install(DefaultHeaders)
    install(CallLogging)
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
    }
}