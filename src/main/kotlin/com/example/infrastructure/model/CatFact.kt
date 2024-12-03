package com.example.infrastructure.model

import com.example.domain.model.CatFact
import kotlinx.serialization.Serializable

@Serializable
class CatFact(val fact: String, val length: Int) {

    fun toDomain(): CatFact {
        return CatFact(fact)
    }
}