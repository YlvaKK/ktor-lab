package com.example.infrastructure.model

import kotlin.test.*

class CatFactTest {

    @Test
    fun toDomain() {
        val fact = CatFact("hei", 3).toDomain()
        val expected = com.example.domain.model.CatFact("hei")
        assertEquals(expected, fact)
    }
}