package com.example.infrastructure

import com.example.infrastructure.model.Breeds
import com.example.infrastructure.model.CatFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class CatFactRepositoryTest {

 @Test
 fun toDomain() {

  val fact = CatFact("hei", 3).toDomain()
  val expected = com.example.domain.model.CatFact("hei")
  assertEquals(expected, fact)
 }

 private val mainThreadSurrogate = newSingleThreadContext("UI thread")

 @Before
 fun setUp() {
  Dispatchers.setMain(mainThreadSurrogate)
 }

 @After
 fun tearDown() {
  Dispatchers.resetMain()
  mainThreadSurrogate.close()
 }

 @Test
 fun testSomeUI(): Unit = runBlocking {
  launch(Dispatchers.Main) {
   val breeds = fetchBreeds()
   assertEquals(breeds.data.size, 98)
  }
 }
}