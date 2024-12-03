package com.example.infrastructure

import com.example.infrastructure.model.CatFact
import kotlin.test.Test
import kotlin.test.assertEquals

class CatFactRepositoryTest {

 @Test
 fun toDomain() {

  val fact = CatFact("hei", 3).toDomain()
  val expected = com.example.domain.model.CatFact("hei")
  assertEquals(expected, fact)
 }
}