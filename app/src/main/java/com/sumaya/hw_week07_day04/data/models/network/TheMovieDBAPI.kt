package com.sumaya.hw_week07_day04.data.models.network

import com.sumaya.hw_week07_day04.data.models.TheMovieDBData
import com.sumaya.hw_week07_day04.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBAPI {

    @GET("movie/popular?api_key=${BuildConfig.Movie_Key}&language=en-US&page=1")
    suspend fun fetchMovies(): TheMovieDBData

    @GET("search/movie?api_key=${BuildConfig.Movie_Key}&language=en-US&page=1&include_adult=false")
    suspend fun searchMovies(@Query("query") searchKeyword:String): TheMovieDBData
}