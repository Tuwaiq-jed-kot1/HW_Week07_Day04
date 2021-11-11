package com.sumaya.hw_week07_day04.ui

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.Results

class MoviesViewModel: BaseObservable() {
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
}