package com.sumaya.hw_week06_day05.network

import MoviesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepo {

    private val api = MovieBuilder.movieApi

    suspend fun fetchMoviesList(): MoviesData = withContext(Dispatchers.IO) {
        api.fetchMovie()

    }

    suspend fun searchMovie(searchKeyWord:String): MoviesData = withContext(Dispatchers.IO) {
        api.searchMovie(searchKeyWord)




    }

}