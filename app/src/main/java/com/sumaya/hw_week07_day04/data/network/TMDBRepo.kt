package com.sumaya.hw_week07_day04.data.network

import com.sumaya.hw_week07_day04.data.model.Data
import com.sumaya.hw_week07_day04.data.model.Rate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TMDBRepo {
    private val api = TMDBBuilder.TMDBAPI
    suspend fun getMovies(): Data = withContext(Dispatchers.IO) {
        api.getMovies()
    }

    suspend fun searchMovies(searchKeyword: String): Data =
        withContext(Dispatchers.IO) {
            api.searchMovies(searchKeyword)
        }

    suspend fun rateMovie(value: Double, movie_id: Int): Rate = withContext(Dispatchers.IO) {
        api.rateMovie(movie_id, value)
    }

    suspend fun deleteRateMovie(movie_id: Int): Rate = withContext(Dispatchers.IO) {
        api.deleteRateMovie(movie_id)
    }
}