package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DomainBreed(
    val breed: String,
    val country: String
) {
}
