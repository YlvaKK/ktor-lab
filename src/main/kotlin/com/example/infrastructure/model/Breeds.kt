package com.example.infrastructure.model

import com.example.domain.model.CatFact
import com.example.domain.model.DomainBreeds
import kotlinx.serialization.Serializable

@Serializable
data class Breeds(val data: List<Breed>) {
    fun toDomain(): DomainBreeds {
        return DomainBreeds(data.stream()
            .map { breed -> breed.toDomain() }
            .toList())
    }
}