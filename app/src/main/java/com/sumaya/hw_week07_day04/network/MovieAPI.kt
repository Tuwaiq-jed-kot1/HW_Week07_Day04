package com.sumaya.hw_week06_day05.network

import MoviesData
import com.sumaya.hw_week07_day04.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
//20124a6b7244b44dfcce4b407d6d3333
   // @GET("movie/popular?api_key=${BuildConfig.MovieDB_API}&language=en-US&page=1")
    @GET("movie/popular?api_key=20124a6b7244b44dfcce4b407d6d3333&language=en-US&page=1")
    suspend fun fetchMovie():MoviesData

    @GET("search/movie?api_key=20124a6b7244b44dfcce4b407d6d3333&language=en-US&page=1&include_adult=false")
        suspend fun searchMovie(@Query("query") searchKeyword:String): MoviesData

}

