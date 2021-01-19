package com.lucascabral.filmescoroutines.ui.main

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getMovies(callback: (movies: List<Movie>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                    listOf(
                            Movie(1, "The Avengers 1"),
                            Movie(2, "The Avengers 2"))
            )
        }).start()
    }

    suspend fun getMoviesCoroutines(): List<Movie> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                    Movie(1, "The Avengers 1"),
                    Movie(2, "The Avengers 2"))
        }
    }
}