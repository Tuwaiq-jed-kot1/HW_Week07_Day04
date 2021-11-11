package com.sumaya.hw_week07_day04.data.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.sumaya.hw_week07_day04.data.modules.Result

class MoviesVM: BaseObservable() {
    var movieVM: Result? =null
        set(vmMovie) {
            field=vmMovie
            notifyChange()
        }

    @get:Bindable
    val title:String?
        get() = movieVM?.title

    @get:Bindable
    val votes:String?
        get() = movieVM?.vote_average.toString()

    @get:Bindable
    val date :String?
        get() = movieVM?.release_date
}