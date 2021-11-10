package com.sumaya.hw_week07_day04.data.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week07_day04.data.movie

class MovieViewModel : BaseObservable() {
    var movie:movie? =null
        set(value) {
            field=value
            notifyChange()
        }

    @get:Bindable
    val title:String?
        get() = movie?.title

    @get:Bindable
    val rating:Double?
        get() = movie?.vote_average

    @get:Bindable
    val release_date :String?
        get() = movie?.release_date

}