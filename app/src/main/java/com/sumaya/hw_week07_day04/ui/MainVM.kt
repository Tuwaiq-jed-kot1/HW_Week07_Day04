package com.sumaya.hw_week06_day05.ui

import MoviesData
import android.util.Log
import androidx.lifecycle.*
import com.sumaya.hw_week06_day05.network.MovieRepo
import kotlinx.coroutines.launch


class MainVM : ViewModel() {
    val repo = MovieRepo()
    fun fetchMoviesList(searchKeyWord: String? = null): LiveData<MoviesData> {
        val movie = MutableLiveData<MoviesData>()
        viewModelScope.launch {
            try {
                if (searchKeyWord.isNullOrEmpty()) {
                    movie.postValue(repo.fetchMoviesList())

                } else {
                    movie.postValue(repo.searchMovie(searchKeyWord))
                }

            } catch (e: Throwable) {
                Log.e("Movies ", "videos  Problem: ${e.localizedMessage}")
            }
        }
        return movie
    }
}