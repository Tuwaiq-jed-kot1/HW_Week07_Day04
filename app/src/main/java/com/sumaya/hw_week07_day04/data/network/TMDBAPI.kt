package com.sumaya.hw_week07_day04.data.network

import com.sumaya.hw_week07_day04.BuildConfig
import com.sumaya.hw_week07_day04.data.model.Rate
import com.sumaya.hw_week07_day04.data.model.Data
import retrofit2.http.*


interface TMDBAPI {
    @GET("movie/popular?api_key=${BuildConfig.apikey}&language=en-US&page=1")
    suspend fun getMovies(): Data

    @GET("search/movie?api_key=${BuildConfig.apikey}&language=en-US&page=1&include_adult=false")
    suspend fun searchMovies(@Query("query") searchKeyword: String): Data


    @POST("movie/{movie_id}/rating?api_key=${BuildConfig.apikey}")
    suspend fun rateMovie(@Path("movie_id") movie_id: Int, @Body value: Double): Rate


    @DELETE("movie/{movie_id}/rating?api_key=${BuildConfig.apikey}")
    suspend fun deleteRateMovie(@Path("movie_id") movie_id: Int): Rate

}