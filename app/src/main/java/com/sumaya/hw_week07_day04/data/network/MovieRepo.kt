package com.sumaya.hw_week07_day04.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.sumaya.hw_week07_day04.data.MovieRoot

class MovieRepo {
    private val api= MovieBuilder.movieApi
    suspend fun getAllmovies(): MovieRoot = withContext(Dispatchers.IO){
        api.getAllmovies()}

    suspend fun searchInMovies(searchKeyword:String): MovieRoot = withContext(Dispatchers.IO){
        api.searchInMovies(searchKeyword)
    }
}