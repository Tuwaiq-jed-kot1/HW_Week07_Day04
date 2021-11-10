package com.sumaya.hw_week07_day04.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.sumaya.hw_week07_day04.data.MovieRoot
import com.sumaya.hw_week07_day04.data.network.MovieRepo

class VMmovies :ViewModel() {
    val repo= MovieRepo()
    fun getAllMovies(searchKeyWord:String? =null): LiveData<MovieRoot> {
        val movies= MutableLiveData<MovieRoot>()
        viewModelScope.launch {
            try {
                if (searchKeyWord.isNullOrEmpty()) {
                    movies.postValue(repo.getAllmovies())
                } else {
                    movies.postValue(repo.searchInMovies(searchKeyWord))
                }

            }catch (e : Throwable){
                Log.e("movies","movies${e.localizedMessage}")

            }

        }
        return movies
    }

}