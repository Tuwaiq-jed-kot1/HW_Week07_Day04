package com.sumaya.hw_week07_day04.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumaya.hw_week07_day04.data.modle.DbData
import com.sumaya.hw_week07_day04.data.network.RepoDB
import kotlinx.coroutines.launch

class MainViewModel():ViewModel(){
    val repo= RepoDB()
    fun fetchMoviesList(searchKeyWord:String? =null): LiveData<DbData> {
        val movies= MutableLiveData<DbData>()
        viewModelScope.launch {
            try {
                if (searchKeyWord.isNullOrEmpty()) {
                    movies.postValue(repo.viewMoviesInfo())
                } else {
                    movies.postValue(repo.searchMovies(searchKeyWord))
                }

            }catch (e : Throwable){
                Log.e("flickr image","Flicker image Problem ${e.localizedMessage}")

            }

        }
        return movies
    }
}