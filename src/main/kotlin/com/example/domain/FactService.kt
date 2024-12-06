package com.example.domain

import com.example.domain.model.CatFact
import com.example.domain.model.DomainBreeds
import com.example.infrastructure.fetchBreeds
import io.ktor.http.*
import io.ktor.server.application.*
import java.util.stream.Collectors
import java.util.stream.Collectors.toList
import kotlin.streams.toList

suspend fun fetchFact(): CatFact {
    val fact = com.example.infrastructure.fetchFact()
    return fact
}

suspend fun fetchBreedsFromACountry(wantedCountry: String): DomainBreeds {
    val allBreeds = fetchBreeds()

    return DomainBreeds(allBreeds.breeds.stream()
        .filter{ breed -> breed.country.lowercase().contains(wantedCountry.lowercase())}
        .toList())
}