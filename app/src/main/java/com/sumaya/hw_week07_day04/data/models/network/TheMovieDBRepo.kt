package com.sumaya.hw_week07_day04.data.models.network

import com.sumaya.hw_week07_day04.data.models.TheMovieDBData
import com.sumaya.hw_week07_day04.data.models.network.TheMovieDBBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TheMovieDBRepo {
    private val api = TheMovieDBBuilder.movieDBApi

    suspend fun fetchInterestingList(): TheMovieDBData = withContext(Dispatchers.IO) {
        api.fetchMovies()
    }
    suspend fun searchMovies(searchKeyword: String): TheMovieDBData = withContext(Dispatchers.IO) {
        api.searchMovies(searchKeyword)
    }
}