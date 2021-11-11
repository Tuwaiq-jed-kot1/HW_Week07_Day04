package com.sumaya.hw_week07_day04.network


import com.sumaya.hw_week07_day04.network.MovieBuilder
import com.sumaya.hw_week07_day04.network.models.MovieData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MovieRepo {

    private val api = MovieBuilder.MOVIE_API

    suspend fun fetchInterestingList(): MovieData = withContext(Dispatchers.IO){
       api.fetchContent()
    }
    suspend fun searchPhotos(searchKeyWord: String): MovieData = withContext(Dispatchers.IO){
       api.searchQuery(searchKeyWord)
    }
}