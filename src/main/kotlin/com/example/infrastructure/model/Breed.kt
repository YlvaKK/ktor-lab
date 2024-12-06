package com.example.infrastructure.model

import com.example.domain.model.DomainBreed
import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    val breed: String,
    val country: String,
    val origin: String,
    val coat: String,
    val pattern: String
) {

    fun toDomain(): DomainBreed {
        return DomainBreed(breed, country)
    }
}
