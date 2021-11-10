package com.sumaya.hw_week06_day05.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumaya.hw_week06_day05.data.models.TheMovieData
import com.sumaya.hw_week06_day05.data.network.TheMovieRepo
import kotlinx.coroutines.launch
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.data.models.Results

class MainViewModel : ViewModel() {
    private val repo = TheMovieRepo()

    fun fetchMoviesList(searchKeyword: String?): LiveData<TheMovieData> {
        val movies = MutableLiveData<TheMovieData>()
        viewModelScope.launch {
            try {
                if (searchKeyword.isNullOrEmpty()) {
                    movies.postValue(repo.fetchMovies())
                } else {
                    movies.postValue(repo.searchMovies(searchKeyword))
                }
            } catch (e: Throwable) {
                Log.e("movie", "The Movie Problem: ${e.localizedMessage}")
            }
        }
        return movies
    }

    class MovieViewModel : BaseObservable() {
        var vmMovie: Results? = null
            set(vmMovie) {
                field = vmMovie
                notifyChange()
            }

        @get:Bindable
        val poster_path: String?
            get() = vmMovie?.poster_path

        @get:Bindable
        val release_date: String?
            get() = vmMovie?.release_date

        @get:Bindable
        val title: String?
            get() = vmMovie?.title

        @get:Bindable
        val vote_average: Double?
            get() = vmMovie?.vote_average

        @get:Bindable
        val id: Int?
            get() = vmMovie?.id

    }

}