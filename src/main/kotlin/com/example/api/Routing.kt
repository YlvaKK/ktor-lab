package com.example.api

import com.example.api.model.FactResponse
import com.example.domain.fetchFact
import com.example.domain.model.CatFact
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/fact") {
            val response: CatFact = fetchFact()
            FactResponse.fromDomain(response)
            call.respondText(Json.encodeToString(response), ContentType.parse("application/json"))
        }
    }
}
