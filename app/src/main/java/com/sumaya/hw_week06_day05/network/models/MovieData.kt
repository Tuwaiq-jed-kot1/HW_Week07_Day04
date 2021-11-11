package com.sumaya.hw_week07_day04.network.models


data class MovieData (

    val results : List<Results>,
)

data class Results (


    val id : Int,
    val poster_path : String,
    val release_date : String,
    val title : String,
    val vote_average : Double,
)