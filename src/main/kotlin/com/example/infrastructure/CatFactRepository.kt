package com.example.infrastructure

import com.example.domain.model.DomainBreeds
import com.example.infrastructure.model.Breeds
import com.example.infrastructure.model.CatFact
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

val deserializer = Json { ignoreUnknownKeys = true }

suspend fun fetchFact(): com.example.domain.model.CatFact {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://catfact.ninja/fact") {
        accept(ContentType.Application.Json)
    }
    val fact = Json.decodeFromString<CatFact>(response.bodyAsText())
    return fact.toDomain()
}

suspend fun fetchBreeds(): DomainBreeds {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://catfact.ninja/breeds") {
        parameter("limit", "100")
        accept(ContentType.Application.Json)
    }
    val breeds = deserializer.decodeFromString<Breeds>(response.bodyAsText())
    return breeds.toDomain()
}