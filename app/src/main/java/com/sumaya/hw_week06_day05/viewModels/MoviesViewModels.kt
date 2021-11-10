package com.shady.restandretrofit.data.viewModels


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.Results

class MoviesViewModels : BaseObservable() {
    var vmMovie: Results? = null
        set(movies) {
            field = movies
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = vmMovie?.title
    val posterPath: String?
        get() = vmMovie?.poster_path
    val releaseDate: String?
        get() = vmMovie?.release_date
    val voteAverage: Double?
        get() = vmMovie?.vote_average



//    data class Results (
//        val id : Int,
//        val poster_path : String,
//        val release_date : String,
//        val title : String,
//        val vote_average : Double,
//    )
}