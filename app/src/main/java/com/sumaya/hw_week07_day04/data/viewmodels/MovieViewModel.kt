package com.sumaya.hw_week06_day05.data.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week06_day05.data.models.TmdbMovie

class MovieViewModel : BaseObservable() {
    var vmMovie: TmdbMovie? = null
    set(vmMovie){
        field = vmMovie
        notifyChange()
    }

    @get:Bindable
    val title: String?
    get() = vmMovie?.title

    val vote: String?
    get() = vmMovie?.vote_average.toString()

    val date: String?
        get() = vmMovie?.release_date
}