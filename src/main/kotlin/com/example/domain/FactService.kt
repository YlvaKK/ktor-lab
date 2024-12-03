package com.example.domain

import com.example.domain.model.CatFact
import io.ktor.http.*
import io.ktor.server.application.*

suspend fun fetchFact(): CatFact {
    val fact = com.example.infrastructure.fetchFact()
    return fact
}