package org.demo

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import kotlinx.html.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    embeddedServer(Netty, port=8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                index()
            }
        }
        route("/components"){
            get("/dashboard") {
                call.respondHtml(HttpStatusCode.OK) {
                    body {
                        tavContent("dashboard")
                    }
                }
            }
            get("/team") {
                call.respondHtml(HttpStatusCode.OK) {
                    body {
                        tavContent("team")
                    }
                }
            }
            get("/projects") {
                call.respondHtml(HttpStatusCode.OK) {
                    body {
                        tavContent("projects")
                    }
                }
            }
            get("/calendar") {
                call.respondHtml(HttpStatusCode.OK) {
                    body {
                        tavContent("calendar")
                    }
                }
            }
            get("/events") {
                call.respondHtml(HttpStatusCode.OK) {
                    body {
                        tavContent("events")
                    }
                }
            }
        }
    }
}

fun HTML.index() {
    head {
        title {
            + "Kotlin + HTMX + Tailwind Example"
        }
        script { src = "https://cdn.tailwindcss.com" }
        script { src = "https://unpkg.com/htmx.org@1.9.10" }
    }
    body{
        classes = setOf("h-full", "bg-gray-500")
        div {
            classes = setOf("min-h-full")
            navbar("Dashboard", "Team", "Projects", "Calendar", "Events")
            tavContent("dashboard")
        }
    }
}

fun FlowContent.navbar(vararg tabs: String) = nav {
    classes = setOf("bg-gray-800")
    div {
        classes = setOf("mx-auto", "max-w-7xl", "px-4", "sm:px-6", "lg:px-8")
        div {
            classes = setOf("flex", "h-24", "items-center", "justify-between")
            div {
                classes = setOf("flex", "items-center")
                div {
                    classes = setOf("flex-shrink-0")
                    div {
                        classes = setOf("block")
                        div {
                            classes = setOf("ml-10", "flex", "items-baseline", "space-x-4")
                            tabs.map {
                                a {
                                    attributes["hx-get"] = "/components/${it.lowercase()}"
                                    attributes["hx-target"] = "#content"
                                    href = "#"
                                    classes =
                                        setOf( "text-grey-300", "hover:bg-gray-700", "hover:text-white", "rounded-md", "px-3", "py-2", "text-sm", "font-medium")
                                    +it
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun FlowContent.tavContent(name: String) = div {
    id = "content"
    header {
        classes = setOf("bg-gray-700", "shadow")
        div {
            classes = setOf("mx-auto", "max-w-7xl", "px-4", "py-6", "sm:px-6", "lg:px-8")
            h1 {
                classes = setOf("text-3xl", "font-bold", "tracking-tight", "text-gray-900")
                + name
            }
        }
    }
    main {
        classes = setOf("mx-auto", "max-w-7xl", "py-6", "sm:px-6", "lg:px-8")
    }
}
