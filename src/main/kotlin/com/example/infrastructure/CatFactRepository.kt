package com.example.infrastructure

import com.example.infrastructure.model.CatFact
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

suspend fun fetchFact(): com.example.domain.model.CatFact {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://catfact.ninja/fact") {
        accept(ContentType.Application.Json)
    }
    val fact = Json.decodeFromString<CatFact>(response.bodyAsText())
    return fact.toDomain()
}