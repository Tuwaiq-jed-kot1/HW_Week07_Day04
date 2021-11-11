package com.sumaya.hw_week06_day05.data.modules


data class Results (
    val id : Int,
    val poster_path : String,
    val release_date : String,
    val title : String,
    val vote_average : Double,
)

data class MoviesData (
    val results : List<Results>,
)
