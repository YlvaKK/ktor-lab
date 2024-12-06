package com.example.domain

import com.example.infrastructure.fetchBreeds
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class FactServiceKtTest {

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
    fun fetchBreedsFromACountry_withSweden_returnsOne(): Unit = runBlocking {
        launch(Dispatchers.Main) {
            val breeds = fetchBreedsFromACountry("swEden")
            assertEquals(breeds.breeds.size, 1)
        }
    }
}