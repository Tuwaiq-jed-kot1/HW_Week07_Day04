package com.sumaya.hw_week07_day04.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class MovieViewModel: BaseObservable() {
    var movie:Results? =null
    set(value) {
        field=value
        notifyChange()
    }

    @get:Bindable
    val title:String?
    get() = movie?.title

    @get:Bindable
    val votes:String?
    get() = movie?.vote_average.toString()

    @get:Bindable
    val date :String?
    get() = movie?.release_date

}