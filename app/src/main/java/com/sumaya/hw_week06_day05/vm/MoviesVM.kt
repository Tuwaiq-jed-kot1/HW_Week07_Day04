package com.sumaya.hw_week06_day05.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.Results

class MoviesVM: BaseObservable() {
    var vmMovies: Results? = null
        set(vmMovies){
            field = vmMovies
            notifyChange()
        }
    @get:Bindable
    val title :String?
        get() = vmMovies?.title

    @get:Bindable
    val posterPath :String?
        get() = vmMovies?.poster_path

    @get:Bindable
    val voteAverage :Double?
        get() = vmMovies?.vote_average

    @get:Bindable
    val releaseDate :String?
        get() = vmMovies?.release_date
}