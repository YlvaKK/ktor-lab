package com.example.api.model

import com.example.domain.model.CatFact

class FactResponse(val response: String) {

    companion object {
        fun fromDomain(domain: CatFact): FactResponse {
            return FactResponse(domain.fact)
        }
    }
}