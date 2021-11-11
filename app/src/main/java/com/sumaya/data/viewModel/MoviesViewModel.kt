package com.sumaya.data.viewModel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.data.models.Movie

class MoviesViewModel : BaseObservable() {
    var vmMovies: Movie? = null
        set(vmMovies) {
            field = vmMovies
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = vmMovies?.title

    @get:Bindable
    val poster_path: String?
        get() = vmMovies?.poster_path

    @get:Bindable
    val release_date: String?
        get() = vmMovies?.release_date

    @get:Bindable
    val vote_average: Double?
        get() = vmMovies?.vote_average


}