package com.lucascabral.filmescoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMovies {
            moviesLiveData.postValue(it)
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