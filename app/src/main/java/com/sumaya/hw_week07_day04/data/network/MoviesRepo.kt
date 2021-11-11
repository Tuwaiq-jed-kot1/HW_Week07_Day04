package com.sumaya.hw_week07_day04.data.network

import com.sumaya.hw_week07_day04.data.modules.MoviesData
import com.sumaya.hw_week07_day04.data.network.MoviesBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepo {
    val api = MoviesBuilder.moviesAPI

    suspend fun fetchList(): MoviesData = withContext(Dispatchers.IO) {
        api.fetchMovies()
    }
    suspend fun searchMovies(searchKeyWord: String): MoviesData = withContext(Dispatchers.IO) {
        api.searchMovies(searchKeyWord)
    }
}
