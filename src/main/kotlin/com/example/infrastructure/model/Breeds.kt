package com.example.infrastructure.model

import com.example.domain.model.CatFact
import kotlinx.serialization.Serializable

@Serializable
data class Breeds(val data: List<Breed>) {
}