package com.lucascabral.filmescoroutines.ui.main

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

    fun getMoviesCoroutines(): List<Movie> {

        return listOf()
    }
}