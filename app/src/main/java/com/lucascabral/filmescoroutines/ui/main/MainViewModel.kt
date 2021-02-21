package com.lucascabral.filmescoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMovies {
            moviesLiveData.postValue(it)
        }
    }

    fun getMoviesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesLiveData.value = movies
        }
    }

    class MainViewModelFactory(
        private val repository: MainRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }

    }
}